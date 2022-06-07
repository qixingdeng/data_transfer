package cn.cttic.roadtransapi.thread.command.imp;

import java.text.ParseException;
import java.util.Date;

import org.apache.log4j.Logger;

import cn.cttic.roadtransapi.mgr.DBMgr;
import cn.cttic.roadtransapi.mgr.ShmMgr;
import cn.cttic.roadtransapi.thread.command.TaskCommandBase;
import cn.cttic.sysframe.common.util.DateUtil;

public class ScanVerifycodeCommand extends TaskCommandBase {

	private static Logger log = Logger.getLogger(ScanVerifycodeCommand.class);
	
	
	@Override
	public void Run() {
		
		long loop = Long.parseLong(DBMgr.getInstance().getRest_scanf_timespace());
		String looplogString= String.format("監聽驗證碼失效程序,[%d]毫秒掃描一次", loop);
		
		long curtime = 0;
		long lastime = 0 ; 
		
		try {
			while (true) {
			
				Date curDate = DateUtil.getCurrentDate(DateUtil.PATTERN_YYYY_MM_DD_HH_MM_SS);
				
				curtime = curDate.getTime();
				
				log.debug(String.format("監聽驗證碼失效程序,正在扫描中.........[%d][%d][%d][%d]毫秒掃描一次", curtime,lastime,curtime - lastime,loop) );
				
				if( (curtime - lastime) >= loop){
					lastime = curtime;
					log.debug(looplogString);
					ShmMgr.getInstance().ScanCheckDetail(DateUtil.format(curDate, DateUtil.PATTERN_YYYY_MM_DD_HH_MM_SS), curtime);
				}
			
				
				Thread.sleep(3000);
				
				
			}
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
