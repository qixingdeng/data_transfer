package cn.cttic.roadtransapi.mgr;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.cxf.jaxrs.impl.MetadataMap;
import org.apache.log4j.Logger;

import cn.cttic.roadtransapi.common.smParamNode;
import cn.cttic.roadtransapi.converter.MyDateConverter;
import cn.cttic.roadtransapi.domain.InterSpcLog;
import cn.cttic.roadtransapi.domain.InterSpcLogWithBLOBs;
import cn.cttic.roadtransapi.orm.waterway.domain.EntStatisInfo;
import cn.cttic.roadtransapi.orm.waterway.domain.MarketSituation;
import cn.cttic.roadtransapi.orm.waterway.domain.RepoEntInfo;
import cn.cttic.roadtransapi.orm.waterway.domain.ShipStatisInfo;
import cn.cttic.roadtransapi.orm.waterway.domain.VoluContainer;
import cn.cttic.roadtransapi.orm.waterway.domain.VoluEntInfo;
import cn.cttic.roadtransapi.orm.waterway.domain.VoluIrreShip;
import cn.cttic.roadtransapi.orm.waterway.domain.VoluPriceInfo;
import cn.cttic.roadtransapi.orm.waterway.domain.VoluRidership;
import cn.cttic.roadtransapi.orm.waterway.domain.VoluShip;
import cn.cttic.roadtransapi.thread.command.imp.ScanVerifycodeCommand;
import cn.cttic.roadtransapi.ws_rest.GatherGnss;
import cn.cttic.roadtransapi.ws_rest.Gnss;
import cn.cttic.roadtransapi.ws_rest.GnssList;
import cn.cttic.sysframe.common.util.DateUtil;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ShmMgr  {
	
	private ShmMgr(){
		Init();
	}
	
	 
	private static Logger log = Logger.getLogger(ShmMgr.class);
	
	
	private static ShmMgr uniqueInstance = null;
	
	public static ShmMgr getInstance() {
	    if (uniqueInstance == null) {
	           uniqueInstance = new ShmMgr();
	       }
	       return uniqueInstance;   
	}
	  
	private void Init(){
		xs = new XStream(new DomDriver("utf-8"));
		
		//xs.registerConverter(new DateConverter("yyyy-MM-dd HH:mm:ss", null,TimeZone.getTimeZone("GMT+8")));
		xs.alias(VoluShip.class.getSimpleName(),VoluShip.class);
		xs.alias(VoluContainer.class.getSimpleName(),VoluContainer.class);
		xs.alias(VoluIrreShip.class.getSimpleName(),VoluIrreShip.class);
		xs.alias(VoluRidership.class.getSimpleName(),VoluRidership.class);
		xs.alias(VoluEntInfo.class.getSimpleName(),VoluEntInfo.class);
		xs.alias(VoluPriceInfo.class.getSimpleName(),VoluPriceInfo.class);
		xs.alias(MarketSituation.class.getSimpleName(),MarketSituation.class);
		xs.alias(RepoEntInfo.class.getSimpleName(),RepoEntInfo.class);
		xs.alias(EntStatisInfo.class.getSimpleName(),EntStatisInfo.class);
		xs.alias(ShipStatisInfo.class.getSimpleName(),ShipStatisInfo.class);
		xs.alias(MetadataMap.class.getSimpleName(),MetadataMap.class);
		xs.alias(smParamNode.class.getSimpleName(),smParamNode.class);
		xs.alias(JSONObject.class.getSimpleName(),JSONObject.class);
		xs.alias(GnssList.class.getSimpleName(),GnssList.class);
		xs.alias(Gnss.class.getSimpleName(),Gnss.class);
		xs.alias(GatherGnss.class.getSimpleName(),GatherGnss.class);
		xs.alias(InterSpcLog.class.getSimpleName(),InterSpcLog.class);
		xs.alias(InterSpcLogWithBLOBs.class.getSimpleName(),InterSpcLogWithBLOBs.class);
		
		xs.alias(PageList.class.getSimpleName(), PageList.class);
		
		xs.processAnnotations(smParamNode.class);
		
		xs.registerConverter(MyDateConverter.Create(), XStream.PRIORITY_VERY_HIGH);
		if(DBMgr.getInstance().getRest_Sign().equals("0")){
			log.debug("根據程序配置，啓動掃描驗證碼線程");
			ScanVerifycodeCommand command = new ScanVerifycodeCommand();
			ThreadMgr.getInstance().ProcessBusi(command);
		}
		
	}
	private XStream xs = null;
	
	public String GetXmlContext(Object obj) {
	
		String context = "";
		try {
			xs.setMode(XStream.NO_REFERENCES);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
			//writer.write("<?xml version=\'1.0\' encoding=\'UTF-8\' ?>");	
			xs.toXML(obj, writer);
			context = outputStream.toString("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String context  = xs.toXML(obj);
		return context ;
	}
    
	public Object GetXmlObj(String obj) {
		
		Object context =null;
		xs.setMode(XStream.NO_REFERENCES);
		context  = xs.fromXML(obj);
		return context ;
	}
	
	private final String lockKey = "n(*≧▽≦*)n";
    
	private Map<String, CheckDetail> checkMap = Maps.newHashMap();
	
	public void ScanCheckDetail(String curtimestr,long curtime){
		
		synchronized (lockKey) {
			List<String> deletelist =Lists.newArrayList();
			CheckDetail temp = null;
			for (Map.Entry<String, CheckDetail> entry : checkMap.entrySet()) {
				temp = entry.getValue();
				temp.setCurtime(curtime);
				temp.setCurtimestr(curtimestr);
				
				long timespace = curtime - temp.getLastcurtime();
				
				if(timespace > temp.getTimespcce()){
					temp.setStatus("1");
					deletelist.add(temp.getVerifycode());
					log.debug(String.format("用戶名:[%s] 驗證碼:[%s] 開始時間:[%s] 失效",temp.getUsername(),temp.getVerifycode(),temp.getLastcurtimestr() ));
				}else{
					temp.setStatus("0");
					log.debug(String.format("用戶名:[%s] 驗證碼:[%s] 開始時間:[%s] 正在有效期..",temp.getUsername(),temp.getVerifycode(),temp.getLastcurtimestr() ));
				}
			}
			
			Iterator iterator = checkMap.keySet().iterator(); 
			for (String key : deletelist) {
				while (iterator.hasNext()) {  
					String strkey = (String) iterator.next();  
					if (strkey.equals(key)) {  
						iterator.remove();        //添加该行代码  
						checkMap.remove(key);      
					}  
				}  

			}
		}
	}
	public void AddCheckDetail(CheckDetail detail){
		if(detail!=null && !Strings.isNullOrEmpty(detail.getVerifycode())){
			synchronized (lockKey) {
				if(checkMap.containsKey(detail.getVerifycode())){
					checkMap.remove(detail);
				}
				
				checkMap.put(detail.getVerifycode(), detail);
			}
		}
	}
	
	public boolean Check(String verifyCode){
		boolean sign = false ; 
		if(!DBMgr.getInstance().getRest_Sign().equals("0")){
			 return sign;
		}
		
		if(Strings.isNullOrEmpty(verifyCode)){
			return sign;
		}
		
		synchronized (lockKey) {
			if(checkMap.containsKey(verifyCode)){
				CheckDetail detail = checkMap.get(verifyCode);
				if(detail.getStatus().equals("0")){
					sign = true;
				}else {
					sign = false;
				}
			}else {
				sign = false;
			}
			
		}
		return sign;
	}
	
	public synchronized CheckDetail CreateCheckDetail(String user){
		CheckDetail detail = new CheckDetail();
		long timespace = Long.parseLong(DBMgr.getInstance().getRest_scanf_timeout());
		detail.setTimespcce(timespace);
		detail.setUsername(user);
		try {
			Date curDate = DateUtil.getCurrentDate(DateUtil.PATTERN_YYYY_MM_DD_HH_MM_SS);
			Long time = curDate.getTime();
			detail.setCurtime(time);
			String timeStr=DateUtil.format(curDate, DateUtil.PATTERN_YYYY_MM_DD_HH_MM_SS);
			detail.setCurtimestr(timeStr);
			
			detail.setLastcurtime(time);
			detail.setLastcurtimestr(timeStr);
			
			// 產生隨機書
			String VerifyCode = CreateVerifyCode();
			detail.setVerifycode(VerifyCode);
			detail.setStatus("");
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return detail ; 
	}
	
	private String CreateVerifyCode(){
		String format= "%06dC%06dC%06d";
		return String.format(format, CreateNum(),CreateNum(),CreateNum());
	}
	
	private int CreateNum() {
		return (int)((float)(0x100000) *Math.random()/(0x7FFF+1.0));
	}
	public class  CheckDetail{
		// 0 .. 1 
		private String status = "0" ; 
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public long getCurtime() {
			return curtime;
		}
		public void setCurtime(long curtime) {
			this.curtime = curtime;
		}
		public String getCurtimestr() {
			return curtimestr;
		}
		public void setCurtimestr(String curtimestr) {
			this.curtimestr = curtimestr;
		}
		public String getVerifycode() {
			return verifycode;
		}
		public void setVerifycode(String verifycode) {
			this.verifycode = verifycode;
		}
		public long getLastcurtime() {
			return lastcurtime;
		}
		public void setLastcurtime(long lastcurtime) {
			this.lastcurtime = lastcurtime;
		}
		public String getLastcurtimestr() {
			return lastcurtimestr;
		}
		public void setLastcurtimestr(String lastcurtimestr) {
			this.lastcurtimestr = lastcurtimestr;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public long getTimespcce() {
			return timespcce;
		}
		public void setTimespcce(long timespcce) {
			this.timespcce = timespcce;
		}
		private long curtime ; 
		private String curtimestr;
		private String verifycode ; 
		private long lastcurtime;
		private String  lastcurtimestr;
		private String username;
		private long timespcce;
	}
}
