package cn.cttic.roadtransapi.mgr;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import cn.cttic.roadtransapi.cache.RedisAPI;
import cn.cttic.roadtransapi.common.ChangeCharset;
import cn.cttic.roadtransapi.common.FormatTransfer;
import cn.cttic.roadtransapi.common.TableValueOper;
import cn.cttic.roadtransapi.ws_rest.GatherGnss;
import cn.cttic.roadtransapi.ws_rest.Gnss;
import cn.cttic.roadtransapi.ws_rest.GnssList;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 
 * 提供单例模式调用工单<br>
 * 
 * @author guoshouzhong@cttic.cn
 * @date 2014年12月3日 上午11:49:50 <br>
 *       Copyright: Copyright (c) 2014 CTTIC
 */
public class RedisMgr {

	// 声明一个ObjectMapperMgr类的引用
	private static RedisMgr instance = null;

	private static Logger log = Logger.getLogger(RedisMgr.class);
	
	private ChangeCharset changeChar = new ChangeCharset();
	
	private RedisMgr() {
		init();
	}

	private JedisPool pool = null;
	private void init(){
	    pool = RedisAPI.getPool(); 
	    
		if(pool!=null && !pool.isClosed()){
			isConnSign = true;
		}else {
			isConnSign = false;
		}
		
		gmap.put("accesscode", new GatherGnssPos("accesscode","1","4","1"));
		gmap.put("trans", new GatherGnssPos("trans","5","2","2"));
		gmap.put("vin", new GatherGnssPos("vin","7","21","0"));
		gmap.put("color", new GatherGnssPos("color","28","2","2")); 
		gmap.put("cur_accesscode", new GatherGnssPos("cur_accesscode","30","4","1"));
		gmap.put("warn_flg", new GatherGnssPos("warn_flg","34","4","1"));
		gmap.put("status_flg", new GatherGnssPos("status_flg","38","4","1")); 
		gmap.put("longitude", new GatherGnssPos("longitude","42","4","1"));
		gmap.put("latitude", new GatherGnssPos("latitude","46","4","1"));
		gmap.put("od_rate", new GatherGnssPos("od_rate","50","2","2")); 
		gmap.put("locator_rate", new GatherGnssPos("locator_rate","52","2","2")); 
		gmap.put("mileage", new GatherGnssPos("mileage","54","4","1")); 
		gmap.put("direction", new GatherGnssPos("direction","58","2","2")); 
		gmap.put("height", new GatherGnssPos("height","60","4","1")); 
		gmap.put("position_time", new GatherGnssPos("position_time","64","22","0")); 
		gmap.put("recv_time", new GatherGnssPos("recv_time","86","22","0"));
		
		
	}
	
	 public static void returnResource(JedisPool pool, Jedis redis) {
	        if (redis != null) {
	            pool.returnResourceObject(redis);
	        }
	 }
	

	 
	public Object GetValue(byte[] key,Jedis redisClient){
		Object valueObject = null;
		
		boolean sign1 = redisClient.exists(key);
	    
		if(sign1){
			String type = redisClient.type(key);
			if(type.equals("string")){
				valueObject = redisClient.get(key) ;

			} else if (type.equals("list")){
				valueObject = new String(redisClient.getrange(key, 0, -1));
			} else if (type.equals("set")){
				 Set<byte[]> arraySet = redisClient.smembers(key);
				 List<byte[]> list = Lists.newArrayList();
				 for (byte[] array : arraySet) {
					 list.add(array);
				}
				 valueObject = list;
			}else {
				valueObject = null;
			}
		}
		
		return valueObject;
	}
	
	
	private Map<String, GatherGnssPos> gmap = Maps.newHashMap();
	
	
	private GatherGnss getGatherGnss( byte[] array) throws Exception, SecurityException{
		GatherGnss objGatherGnss= new GatherGnss();
		Field[] fields = objGatherGnss.getClass().getDeclaredFields();
		
		
		for (Field field : fields) {
			String fieldname = field.getName();
			if(fieldname.equals("this$0")){
				continue;
			}
			String func="set" + TableValueOper.GetValueName(fieldname);
			Method method = objGatherGnss.getClass().getDeclaredMethod(func, String.class);
			GatherGnssPos gatherGnssPos = gmap.get(fieldname);
			if(method!=null && gatherGnssPos!=null){
				Object result=null;
				int len = Integer.parseInt(gatherGnssPos.getLen());
				byte[] intbytes = new byte[len];
				System.arraycopy(array , Integer.parseInt(gatherGnssPos.getBeginPos())-1, intbytes,0 ,len );
				
				if(gatherGnssPos.getType().equals("1")){
					
					byte[] reversebuffer = FormatTransfer.bytesReverseOrder(intbytes);
					ByteBuffer bbuffer = ByteBuffer.wrap(reversebuffer);
					int var = bbuffer.asIntBuffer().get();
					result = Integer.toString(var);
				} else if  (gatherGnssPos.getType().equals("2")) {
					byte[] reversebuffer = FormatTransfer.bytesReverseOrder(intbytes);
					ByteBuffer bbuffer = ByteBuffer.wrap(reversebuffer);
					short var = bbuffer.asShortBuffer().get();
					result = Integer.toString(var);
				}else {
					String stresult = new String(intbytes,"GBK");
					result=stresult.trim();
				}
				method.invoke(objGatherGnss, result);
			}
		}
		
		return objGatherGnss ;
	}
	
	
	private int GetRedis(byte[] key , GnssList gnsslist,Jedis redisClient ) throws  Exception{
		int ret = -1 ;
		Object obj = GetValue(key,redisClient);
		if(obj!=null){
			if(obj.getClass().getSimpleName().equals("ArrayList")){
				List<byte[]> list = (List<byte[]>) obj;
				for (byte[] subkey : list) {
					ret = GetRedis(subkey,gnsslist,redisClient);
					if(ret < 0){
						return ret;
					}
				}
			}else {
				GatherGnss objGatherGnss=getGatherGnss((byte[])obj);
				if(objGatherGnss!=null){
					Gnss gnss=  new Gnss();
					gnss.setGatherGnsse(objGatherGnss);
					gnsslist.getGatherGnsses().add(gnss);
					
				}
			}
		}
		ret = 0 ;
		return ret;
	}
	
	public String GetCurMap(String key) throws Exception{	
		GnssList gnsslist  = new GnssList();
		String valueString = null;
		
		if(isConnSign){
			Jedis redisClient = null;
			try {
			    redisClient=pool.getResource();  
			    int ret = GetRedis(key.getBytes(),gnsslist,redisClient);
				if(ret < 0){
					gnsslist.setCode("-1");
					gnsslist.getGatherGnsses().clear();
					valueString = null;
				}else {
					gnsslist.setCode("0");
					valueString = ObjectMapperMgr.getInstance().fromBeanToJson(gnsslist);
				}
				
				
			} catch (Exception e) {
				returnResource(pool, redisClient);
				if(e.getClass().getSimpleName().equals("JedisConnectionException")){
					isConnSign = false;
				}
				
				gnsslist.setCode("-2");
				gnsslist.getGatherGnsses().clear();
				
			}finally{
				returnResource(pool, redisClient);
			}
		    
			
		}
		
		
		return valueString;
	}
	
	
	
	
	private boolean isConnSign = false;
	
	public static synchronized RedisMgr getInstance() {
		if (instance == null) {
			instance = new RedisMgr();
		}
		return instance;
	}

	public boolean isConnSign() {
		return isConnSign;
	}
	


	private class GatherGnssPos{
		
		public GatherGnssPos(String propname,String beginPos,String len,String type){
			setPropname(propname);
			setBeginPos(beginPos);
			setLen(len);
			setType(type);
		}
		
		public String getPropname() {
			return propname;
		}
		public void setPropname(String propname) {
			this.propname = propname;
		}
		public String getBeginPos() {
			return beginPos;
		}
		public void setBeginPos(String beginPos) {
			this.beginPos = beginPos;
		}
		public String getLen() {
			return len;
		}
		public void setLen(String len) {
			this.len = len;
		}
		
		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
		
		private String beginPos;
		private String len;
		private String propname;
		private String type;
		
	}
	
	public void setVelue2Redis(String key, String value)
	{
		if(isConnSign){
			Jedis redisClient = null;
			try 
			{
			    redisClient=pool.getResource();  
			    String ret = redisClient.set(key.getBytes(), value.getBytes());
			} 
			catch (Exception e) 
			{
				log.debug("======Write2Redis Exception=========");
				returnResource(pool, redisClient);
				if(e.getClass().getSimpleName().equals("JedisConnectionException")){
					isConnSign = false;
				}
				
			}finally{
				returnResource(pool, redisClient);
			}
		}
	}
	
}
