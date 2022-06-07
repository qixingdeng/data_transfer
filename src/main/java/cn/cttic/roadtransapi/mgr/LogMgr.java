package cn.cttic.roadtransapi.mgr;

import java.util.Map;

import org.apache.log4j.Logger;

import cn.cttic.roadtransapi.code.InterLogProcCode;
import cn.cttic.roadtransapi.constants.RoadWayConstants;
import cn.cttic.roadtransapi.thread.command.imp.DataLoadLogCommand;

import com.google.common.base.Strings;



public class LogMgr  {
	
	private static LogMgr instan = null;
	
	public static LogMgr getInstance() {
	    if (instan == null) {
	    	instan = new LogMgr();
	       }
	       return instan;   
	}
	
	private LogMgr(){
		init();
	}
	
	private static Logger log = Logger.getLogger(LogMgr.class);
	
	private void init(){
		String logsign = DBMgr.getInstance().getLog_dataload_sign();
		
		if(Strings.isNullOrEmpty(logsign) || logsign.equals("0")){
			sign = false;
		}else {
			sign = true;
		}
		
		if(sign){
			log.debug("日志入库的功能被开启");
		}else {
			log.debug("日志入库的功能不会被开启");
		}
	}
	
	private Object lockObject = new Object();
	
	public void BusiProc(Object sender ,  Object source ){
		if(!sign){
			log.debug("日志入库的功能开关没有被开启,配置文件的[log.sign]");
			return;
		}else {
			log.debug("日志入库的功能开关开启,将日志入库");
		}
		
		synchronized (lockObject) {
			
			Map<String, Object> sourecMap = (Map<String, Object>) source ;
			InterLogProcCode code = (InterLogProcCode) sourecMap.get(RoadWayConstants.CXF_STEP);
			
			if(code == InterLogProcCode.ALL_STEP || code == InterLogProcCode.RECEIVE_REQ_STEP || code == InterLogProcCode.SEND_RESP_STEP){
				DataLoadLogCommand  command = new DataLoadLogCommand();
				command.setSource(source);
				command.SysnExecute();
			}
			
		}
		
	}
	
	private boolean sign = false;

	public boolean isSign() {
		return sign;
	}

	
	
}
