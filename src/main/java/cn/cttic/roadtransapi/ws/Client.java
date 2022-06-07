package cn.cttic.roadtransapi.ws;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.cttic.roadtransapi.common.ChangeCharset;
import cn.cttic.roadtransapi.exception.RoadWayService;
import cn.cttic.roadtransapi.orm.roadway.domain.DwBaseinfoRoadowner;
import cn.cttic.roadtransapi.signature.Base64;
import cn.cttic.roadtransapi.signature.MD5Util;
import cn.cttic.roadtransapi.signature.Signaturer;

public class Client {
	
	static int success = 0;
	
	static int fail = 0;
	
	private synchronized void succ()
	{
		success++;
	}
	private synchronized void faill()
	{
		fail++;
	}
	
	class MyThread extends Thread
	{
        private int index = 0;
		
		public MyThread(int index)
		{
			this.index = index;
		}
		@Override
		public void run()
		{
			 ChangeCharset changeCharset = new ChangeCharset();
				
			 String context = "";
			 
			 String e0101 = "<?xml version='1.0' encoding='utf-8'?><reqInfo><ownerName>浦华环保有限公司</ownerName><provinceCode>110000</provinceCode></reqInfo>";
			 
			 context = e0101; 
			 
			 
			 //GetXml GetXml = new GetXml("C:\\Users\\LiKai\\Desktop\\XSLTFile1.xml");
			// context = GetXml.xmlToString();
			  RoadWayServiceImpService service = new RoadWayServiceImpService();
			  RoadWayService portType = service.getRoadWayServiceImpPort();
			
			  cn.cttic.roadtransapi.ws.Command.Transaction transaction = new cn.cttic.roadtransapi.ws.Command.Transaction();
			  
			  TransactionHeaderList value = new TransactionHeaderList();
			  transaction.setTransactionHeader(value);
			  
			  
			  value.setTransactionSerialnum("2015042210001");
			  value.setTransactionSourceservice("320000");
			  value.setTransactionTargetservice("000000");
			  value.setTransactionDate("20150422");
			  value.setTransactionTime("10:23:12");
			  value.setTransactionSystemId("1001");
			  value.setTransactionServiceId("A0101");
			  value.setTransactionIsreq("0");
			  
			  TransactionSignature transactionSignature = new TransactionSignature();
			  value.setTransactionSignature(transactionSignature);
			  
			  String publikeyString = "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAsVxoodyPsdYQlQnnfrYT+hWDwrnt\n"+
					  "s0XNkw/AkEngROWAkIvdfqVD1qgC/FBPFcwwMfDHjkOf1iaYMCrMDt6ZbQIDAQABAkApm+NULdls\n"+
					  "QCstu+AaYv72ybtaoKH6T+L1oFltwFcj8koK5bpzBpB1fJfUsP1VctFFXizKWbKbmiNOqHN6TmXl\n"+
					  "AiEA/uo55caHNGUP+2wsUwwgZU/+mMhc0s07shTf2PEbv78CIQCyHaySyd3U5mmJTFwYkbxUvrCP\n"+
					  "kdxlJeB6KllIjbQx0wIhAPJT/bgmM0+mpzvOyJAmHgHRuujIyB0JRy9yUp3sDwIHAiBCx2NbSXn1\n"+
					  "B0oMIufogkNE1pWlzj7+YTwPMW92B0LG5wIgXvtv0FKFoLNNHhmrEyIEeL9qcdjCYhna/4S4cCLk\n"+
					  "HkM=";
			  
			  String base64 = Base64.getBase64(context);
			  String lineSeparator = System.getProperty("line.separator");
				Pattern p = Pattern.compile("\\s*|\t|\r|\n");
				Matcher m = p.matcher(base64);
				base64 = m.replaceAll("");
			  String repString = null;
			
			  String md5 = MD5Util.strToMD5(base64);
			  
			  System.out.println(md5);
			 
			  String signString = new String( Signaturer.sign(publikeyString.getBytes(), md5));
			  
			  transactionSignature.setTransactionDetail(signString);
			  transaction.setTransactionBody(context);
			  cn.cttic.roadtransapi.ws.CommandResponse.Transaction resptransaction = portType.command(transaction);
			  
			  String resp="";
			try {
				resp = changeCharset.toGBK(resptransaction.getTransactionBody());
				System.out.println(resp);
				
				succ();
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}
	}
	
	public void test()
	{
		try
		{
			for (int i = 0; i < 1; i++)
			{
				Thread t = new MyThread(i);
				t.start();
				//Thread.currentThread().sleep(10);
			}
			
			Thread.sleep(4*1000);
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& "+success);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
		Client client = new Client();
		
		client.test();
		
		DwBaseinfoRoadowner temp = new DwBaseinfoRoadowner() ;
		
	}
}
