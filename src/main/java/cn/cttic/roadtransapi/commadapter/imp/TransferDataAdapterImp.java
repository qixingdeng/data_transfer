/*
 * Project: RDTRANS
 * Copyright 2015 CTTIC
 * All right reserved.
 */
package cn.cttic.roadtransapi.commadapter.imp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import cn.cttic.core.util.Base64Util;
import cn.cttic.core.util.MD5Util;
import cn.cttic.core.util.Signaturer;
import cn.cttic.roadtransapi.code.InterStatusCode;
import cn.cttic.roadtransapi.commadapter.RoadWayAdapter;
import cn.cttic.roadtransapi.common.XmlOper;
import cn.cttic.roadtransapi.ws_roadway.TransactionHeaderList;
import cn.cttic.roadtransapi.ws_roadway.TransactionSignature;

/**
 * 建立日期 : 2015-9-6 下午2:13:11<br>
 * 作者 : liuzhenliang@cttic.cn<br>
 * 模块 : <br>
 * 描述 : <br>
 * 修改历史 <br>
 * 序号 日期 修改人 修改原因 <br>
 * 1 <br>
 * 2 <br>
 */
public class TransferDataAdapterImp extends HttpRoadWayAdapterImp  
{
	private static Logger log = Logger.getLogger(TransferDataAdapterImp.class);
	
	@Override
	public String ProcessReqContext(String reqcontext){
		cn.cttic.roadtransapi.ws_roadway.Transaction transaction = new cn.cttic.roadtransapi.ws_roadway.Transaction();
		
		String busiCode = "QA0101";
		String context = reqcontext;
		TransactionHeaderList value = new TransactionHeaderList();
		transaction.setTransactionHeader(value);
		  
		value.setTransactionSerialnum("2015042210001");
		value.setTransactionSourceservice("320000");
		value.setTransactionTargetservice("000000");
		value.setTransactionDate("20150422");
		value.setTransactionTime("102312");
		value.setTransactionSystemId("1001");
		value.setTransactionServiceId(busiCode);
		value.setTransactionIsreq("0");
		  
		TransactionSignature transactionSignature = new TransactionSignature();
		value.setTransactionSignature(transactionSignature);
		  
		String privatekeyString = "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAsVxoodyPsdYQlQnnfrYT+hWDwrnt\n"+
				  "s0XNkw/AkEngROWAkIvdfqVD1qgC/FBPFcwwMfDHjkOf1iaYMCrMDt6ZbQIDAQABAkApm+NULdls\n"+
				  "QCstu+AaYv72ybtaoKH6T+L1oFltwFcj8koK5bpzBpB1fJfUsP1VctFFXizKWbKbmiNOqHN6TmXl\n"+
				  "AiEA/uo55caHNGUP+2wsUwwgZU/+mMhc0s07shTf2PEbv78CIQCyHaySyd3U5mmJTFwYkbxUvrCP\n"+
				  "kdxlJeB6KllIjbQx0wIhAPJT/bgmM0+mpzvOyJAmHgHRuujIyB0JRy9yUp3sDwIHAiBCx2NbSXn1\n"+
				  "B0oMIufogkNE1pWlzj7+YTwPMW92B0LG5wIgXvtv0FKFoLNNHhmrEyIEeL9qcdjCYhna/4S4cCLk\n"+
				  "HkM=";
		  
		String base64 = Base64Util.getBase64(context);
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		Matcher m = p.matcher(base64);
		base64 = m.replaceAll("");
		String md5 = MD5Util.strToMD5(base64);
		String signString = new String( Signaturer.sign(privatekeyString.getBytes(), md5));
		transactionSignature.setTransactionDetail(signString);
		transaction.setTransactionBody(context);
		
		//Transaction resptransaction = portType.command(transaction);
		
		String newreqcontext = XmlOper.bean2Xml(transaction);
		log.info("&&&&&&&&&"+reqcontext);
		return newreqcontext;
	}
	
	
	@Override
	public InterStatusCode ProcessRespAdapter(String reqcontext,StringBuffer context){
		InterStatusCode ret = InterStatusCode.SUCCESS;
		return ret;
	} 
	
	@Override
	public RoadWayAdapter NewRoadWayAdapter() {
		// TODO Auto-generated method stub
		return new TransferDataAdapterImp();
	}
}
