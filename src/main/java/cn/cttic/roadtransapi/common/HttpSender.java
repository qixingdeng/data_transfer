package cn.cttic.roadtransapi.common;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;

public class HttpSender {
	  private static int timeout = 5000;

	  private static Logger logger = Logger.getLogger(HttpSender.class);
	  
	  public static String doPost(String xml, String requestURL)
	    throws Exception
	  {
	    String retStr = "";
	    try {
	      URL url = new URL(requestURL);
	      URLConnection uc = url.openConnection();
	      uc.setConnectTimeout(timeout);
	      uc.setReadTimeout(timeout);
	      uc.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
	      uc.setRequestProperty("User-Agent", "Mozilla/4.0");
	      uc.setRequestProperty("Accept", "application/soap+xml, application/dime, multipart/related, text/*");
	      uc.setRequestProperty("Accept-Encoding", "gzip, deflate");
	      uc.setRequestProperty("Cache-Control", "no-cache");
	      uc.setRequestProperty("no-cache", "no-cache");
	      uc.setDoOutput(true);
	      uc.setDoInput(true);

	      HttpURLConnection httpConnection = (HttpURLConnection)uc;
	      httpConnection.setRequestMethod("POST");

	      OutputStream os = httpConnection.getOutputStream();

	      byte[] bt = (byte[])null;
	      bt = xml.getBytes();
	      os.write(bt);
	      os.close();
	      int rspCode = httpConnection.getResponseCode();

	      InputStream is = null;
	      if (rspCode == 200)
	        is = httpConnection.getInputStream();
	      else {
	        is = httpConnection.getErrorStream();
	      }

	      InputStreamReader isr = new InputStreamReader(is, "UTF-8");
	      BufferedReader br = new BufferedReader(isr);
	      String tstr = "";
	      String data = "";
	      String dataTmp = "";
	      while ((tstr = br.readLine()) != null) {
	        data = data + tstr + "\n";
	        dataTmp = dataTmp + tstr;
	      }
	      retStr = data;
	      isr.close();
	      is.close();
	    } catch (Exception ee) {
	      ee.printStackTrace();
	      throw new Exception(ee);
	    }
	    return retStr;
	  }

	  public static String callService(String xmlStr, String soapAction, String requestURL) throws Exception {
		    String retStr = "";
		    try {
		      URL url = new URL(requestURL);
		      URLConnection urlConnection = url.openConnection();

		      urlConnection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
		      urlConnection.setRequestProperty("User-Agent", "Mozilla/4.0");
		      urlConnection.setRequestProperty("Accept", "application/soap+xml, application/dime, multipart/related, text/*");

		      urlConnection.setRequestProperty("SOAPAction", soapAction);
		      urlConnection.setRequestProperty("Cache-Control", "no-cache");
		      urlConnection.setRequestProperty("Pragma", "no-cache");
		      urlConnection.setDoOutput(true);
		      urlConnection.setDoInput(true);

		      HttpURLConnection httpConnection = (HttpURLConnection)urlConnection;
		      httpConnection.setRequestMethod("POST");

		      OutputStream os = httpConnection.getOutputStream();
		      byte[] bt = xmlStr.getBytes();
		      os.write(bt);
		      os.flush();
		      os.close();
		      InputStream is = null;
		      int rspCode = httpConnection.getResponseCode();
		      logger.debug("HttpResponseCode=" + rspCode);
		      if (rspCode == 200)
		        is = httpConnection.getInputStream();
		      else {
		        is = httpConnection.getErrorStream();
		      }

		      InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		      BufferedReader br = new BufferedReader(isr);
		      String tstr = "";
		      String data = "";
		      String dataTmp = "";
		      while ((tstr = br.readLine()) != null) {
		        data = data + tstr + "\n";
		        dataTmp = dataTmp + tstr;
		      }
		      if (dataTmp.trim().length() <= 0)
		        throw new Exception();

		      retStr = data;
		      isr.close();
		      is.close();
		    } catch (Exception ee) {
		      ee.printStackTrace();
		      retStr = "<error>error</error>";
		      throw new Exception();
		    }
		    return retStr;
		  }
}
