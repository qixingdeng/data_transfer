package cn.cttic.roadtransapi.interceptor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.io.CacheAndWriteOutputStream;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.io.CachedOutputStreamCallback;
import org.apache.cxf.message.Message;

import cn.cttic.roadtransapi.code.InterLogProcCode;
import cn.cttic.roadtransapi.constants.RoadWayConstants;
import cn.cttic.roadtransapi.mgr.LogMgr;
import cn.cttic.sysframe.common.util.DateUtil;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

public class MyLoggingOutInterceptor extends LoggingOutInterceptor{
	public void handleMessage(Message message) throws Fault{
		
		super.handleMessage(message);
		
		if(LogMgr.getInstance().isSign()){
			OutputStream os = null;
			String xml = null;
			try {
				os = message.getContent(OutputStream.class);  
				  
				CachedStream cs = new CachedStream();  

				message.setContent(OutputStream.class, cs);  

				message.getInterceptorChain().doIntercept(message);  

				CachedOutputStream csnew = (CachedOutputStream) message.getContent(OutputStream.class);  
				InputStream in = csnew.getInputStream();  
				  
				xml = IOUtils.toString(in);  
				  
				//这里对xml做处理，处理完后同理，写回流中  
				IOUtils.copy(new ByteArrayInputStream(xml.getBytes("utf-8")), os);  
				  
				cs.close();  
				os.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}  

	        message.setContent(OutputStream.class, os);  
	        
	        
	        Map<String, Object> sourecMap = Maps.newHashMap();
	        
	        sourecMap.put(RoadWayConstants.CXF_STEP, InterLogProcCode.SEND_RESP_STEP); 
	        
	        sourecMap.put(InterLogProcCode.SEND_RESP_STEP.getCode(), message);
	        
	        String encoding = (String)message.get(Message.ENCODING);
			String httpMethod = (String)message.get(Message.HTTP_REQUEST_METHOD);
			String ct = (String)message.get(Message.CONTENT_TYPE);
			String address = (String)message.get(Message.ENDPOINT_ADDRESS);
			
			sourecMap.put(Message.ENCODING, encoding);
			sourecMap.put(Message.HTTP_REQUEST_METHOD, httpMethod);
			sourecMap.put(Message.CONTENT_TYPE, ct);
			sourecMap.put(Message.ENDPOINT_ADDRESS, address);
			
	        java.util.Date receivDate = (java.util.Date) DateUtil.getServerDate();
	        sourecMap.put(RoadWayConstants.RECVIVE_DATE, receivDate);
	        
	        sourecMap.put(RoadWayConstants.BUSI_CONTEXT, xml);
	        
	        LogMgr.getInstance().BusiProc(this, sourecMap);
			
		}
		
		
		
	}
	
	
	
	private class CachedStream extends CachedOutputStream {  
		  
        public CachedStream() {  
  
            super();  
  
        }  
  
        protected void doFlush() throws IOException {  
  
            currentStream.flush();  
  
        }  
  
        protected void doClose() throws IOException {  
  
        }  
  
        protected void onWrite() throws IOException {  
  
        }  
  
    }  
	
	
	public class MyCachedOutputStreamCallback implements CachedOutputStreamCallback {

		private Message message;

		public MyCachedOutputStreamCallback() {
		}
		
		public MyCachedOutputStreamCallback(Message message) {
			this.message = message;
		}

		@Override
		public void onClose(CachedOutputStream os) {
			
			Map<String, Object> sourecMap = Maps.newHashMap();
	        
	        sourecMap.put(RoadWayConstants.CXF_STEP, InterLogProcCode.SEND_RESP_STEP); 
	        
	        sourecMap.put(InterLogProcCode.SEND_RESP_STEP.getCode(), message);
	        
	        String encoding = (String)message.get(Message.ENCODING);
			String httpMethod = (String)message.get(Message.HTTP_REQUEST_METHOD);
			String ct = (String)message.get(Message.CONTENT_TYPE);
			String address = (String)message.get(Message.ENDPOINT_ADDRESS);
			
			sourecMap.put(Message.ENCODING, encoding);
			sourecMap.put(Message.HTTP_REQUEST_METHOD, httpMethod);
			sourecMap.put(Message.CONTENT_TYPE, ct);
			sourecMap.put(Message.ENDPOINT_ADDRESS, address);
			
	        java.util.Date receivDate = (java.util.Date) DateUtil.getServerDate();
	        sourecMap.put(RoadWayConstants.RECVIVE_DATE, receivDate);
	        
	        StringBuilder  builder = new StringBuilder();
	        CacheAndWriteOutputStream newOut =null;
			try {
				final OutputStream outos = message.getContent(OutputStream.class);
			    newOut = new CacheAndWriteOutputStream(outos);
				writePayload(builder, newOut, encoding, ct);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
	                //empty out the cache
					newOut.lockOutputStream();
					newOut.resetOut(null, false);
	            } catch (Exception ex) {
	                //ignore
	            }
			}
			
			//读取os中的内容
	        if(!Strings.isNullOrEmpty(builder.toString())){
	        	sourecMap.put(RoadWayConstants.BUSI_CONTEXT, builder.toString());
	        }
	        
	        LogMgr.getInstance().BusiProc(this, sourecMap);
		}

		@Override
		public void onFlush(CachedOutputStream os) {

		}

	}

}
