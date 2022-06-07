package cn.cttic.roadtransapi.ws_roadway;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.cttic.roadtransapi.common.CommUtil;
import cn.cttic.roadtransapi.orm.roadway.domain.DwBaseinfoRoadowner;
import cn.cttic.roadtransapi.signature.Base64;
import cn.cttic.roadtransapi.signature.MD5Util;
import cn.cttic.roadtransapi.signature.Signaturer;
import cn.cttic.roadtransapi.ws_roadway.service.RoadTransService;
import cn.cttic.roadtransapi.ws_roadway.service.imp.RoadTransServiceImplService;

public class Client {
	
	static int success = 0;
	
	static int fail = 0;
	
	static Map fileMap = new HashMap();
	
	static{
		String path = System.getProperty("user.dir");
		path = path + "\\src\\main\\resources\\script\\test";
		File file = new File(path);
		String[] filelist = file.list();
        for (int i = 0; i < filelist.length; i++) {
        	//System.out.println(filelist[i]);
            String key = filelist[i].substring(0,filelist[i].indexOf("."));
            fileMap.put(key,path + "\\" + filelist[i]);
        }
	}
	
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
			String busiCode = "QC0104";
			String fileName = (String)fileMap.get(busiCode);
			String context = CommUtil.readFromFile(fileName);
					 
			RoadTransServiceImplService service = new RoadTransServiceImplService();
			RoadTransService portType = service.getRoadTransServiceImplPort();
			
		    Transaction transaction = new Transaction();
			  
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
			  
			String base64 = Base64.getBase64(context);
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(base64);
			base64 = m.replaceAll("");
			String md5 = MD5Util.strToMD5(base64);
			String signString = new String( Signaturer.sign(privatekeyString.getBytes(), md5));
			transactionSignature.setTransactionDetail(signString);
			transaction.setTransactionBody(context);
			
			Transaction resptransaction = portType.command(transaction);
			  
			String resp="";
			try {
				resp = resptransaction.getTransactionBody();
				System.out.println(resp);
				
				succ();
				
			} catch (Exception e) {
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
				Thread.currentThread().sleep(10);
			}
			
			Thread.sleep(4*1000);
			System.out.println("******************************** "+success);
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
