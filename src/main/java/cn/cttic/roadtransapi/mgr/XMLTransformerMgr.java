package cn.cttic.roadtransapi.mgr;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;

import cn.cttic.roadtransapi.code.InterStatusCode;
import cn.cttic.roadtransapi.common.XmlOper;
import cn.cttic.roadtransapi.common.smParamNode;
import cn.cttic.roadtransapi.constants.RoadWayConstants;
import cn.cttic.roadtransapi.domain.InterSpcAttr;
import cn.cttic.roadtransapi.domain.InterSwapPlatformConfigWithBLOBs;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

public class XMLTransformerMgr {
	
	private XMLTransformerMgr(){
		Initialize();
	}
	
	public static final String CLIENT_REQ_PREFIX = "CREQ";
	public static final String CLIENT_RSP_PREFIX = "CRSP";
	public static final String CLIENT_SPC_ATTR = "SPC_ATTR";
	
	private static Logger log = Logger.getLogger(XMLTransformerMgr.class);
	
	private static XMLTransformerMgr uniqueInstance = null;
	
	public static XMLTransformerMgr getInstance() {
	    if (uniqueInstance == null) {
	           uniqueInstance = new XMLTransformerMgr();
	           
	       }
	    
	       if (uniqueInstance.isInitSign == false)
	       {
	    	   uniqueInstance.Initialize();
	    	   uniqueInstance.isInitSign = true;
	       }
	       return uniqueInstance;   
	}
	  
	private  boolean isInitSign = false;
	
	private InterStatusCode Initialize() {
		InterStatusCode code = InterStatusCode.SUCCESS;
		List<InterSwapPlatformConfigWithBLOBs> configlist= DBMgr.getInstance().getConfiglist();
		if(configlist!=null&&configlist.size() >0){
			for(InterSwapPlatformConfigWithBLOBs config : configlist){
				
				String type = config.getAdapterType();
				
		    	if(!Strings.isNullOrEmpty(config.getReqBody())){
		    		String key=CLIENT_REQ_PREFIX+"_"+config.getSystemId()+config.getServiceId();
		    		ProcessXsd(key,config.getReqBody());
		    		ProcessXsd(type,config.getReqBody());
		    	}
		    	
		    	if(!Strings.isNullOrEmpty(config.getRespBody())){
		    		String key=CLIENT_RSP_PREFIX+"_"+config.getSystemId()+config.getServiceId();
		    		ProcessXsd(key,config.getRespBody());
		    		ProcessXsd(type,config.getRespBody());
		    	}
		    	
		    	
		    	if(!Strings.isNullOrEmpty(config.getReqBody())){
		    		String key=CLIENT_REQ_PREFIX+"_"+config.getAdapterType();
		    		ProcessXsd(key,config.getReqBody());
		    		ProcessXsd(type,config.getReqBody());
		    	}
		    	
		    	if(!Strings.isNullOrEmpty(config.getRespBody())){
		    		String key=CLIENT_RSP_PREFIX+"_"+config.getAdapterType();
		    		ProcessXsd(key,config.getRespBody());
		    		ProcessXsd(type,config.getRespBody());
		    	}
		    	
		    }
		}
		
		List<InterSpcAttr> attrlist = DBMgr.getInstance().getAttrConfiglist();
		if(attrlist!=null&&attrlist.size() >0){
			for(InterSpcAttr config : attrlist){
		    	if(!Strings.isNullOrEmpty(config.getReqBody())){
		    		String key=CLIENT_SPC_ATTR+"_"+config.getId();
		    		code = ProcessXsd(key,config.getReqBody());
		    	}
		    }
		}
		
		
		String classpath = DBMgr.class.getResource("/").getPath();
		String jsonfile = classpath + "data/xml2json.xslt";
		File d = new File(jsonfile);
		if(d.exists() && d.canRead()){
			code =ProcessXsd(d,xmlToJsonEntry);
			if(code == InterStatusCode.SUCCESS){
				xmlToJsonEntry.setXsltid(XMLTOJSONENTRY_KEY);
				XmlToJsonSign = true;
			}
		}else {
			XmlToJsonSign = false;
		}
		return code;
	}
	
	public String BusiProecess(String xmlcontext ){
		String json = null;
		if(!Strings.isNullOrEmpty( xmlcontext)){
			if(XmlToJsonSign){
				try {
					Transformer transformer = xmlToJsonEntry.getTemplates().newTransformer();
					transformer.setOutputProperty(OutputKeys.ENCODING, RoadWayConstants.DEFAULT_ENCODING);
					Source xmlSource = new StreamSource(new StringReader(xmlcontext));
				    StringWriter stringWriter = new StringWriter();
				    Result result = new StreamResult(stringWriter);
				    transformer.transform(xmlSource, result);
				    json = stringWriter.getBuffer().toString();
				    stringWriter.close();
				} catch(Exception e){
					log.error("XML转换错误", e);
				}
			}
		}
		
		return json ;
	}
	
	private String readFile(FileReader reader)
		    throws IOException
		  {
		    StringBuffer stringBuffer = new StringBuffer();
		    BufferedReader bf = new BufferedReader(reader);
		    String line = "";
		    while ((line = bf.readLine()) != null) {
		      stringBuffer.append(line);
		      stringBuffer.append("\n");
		    }
		    bf.close();
		    return stringBuffer.toString();
		  }
	
	private InterStatusCode ProcessXsd(File xsdfile,XSLTEntry entry){
		InterStatusCode code = InterStatusCode.SUCCESS;
		try {
			FileReader reader = new FileReader(xsdfile);
			String context = readFile(reader);
			if(!Strings.isNullOrEmpty(context)){
				
				Source xslSource = new StreamSource(xsdfile);
			    TransformerFactory transFact = TransformerFactory.newInstance();
			    try {
					Templates templates = transFact.newTemplates(xslSource);
					entry.setTemplates(templates);
					
				} catch (TransformerConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					code=InterStatusCode.USER_DEFINDES_ERROR;
				}       
			}else{
				error_msg = ":文件[%s],内容为null！";
				String.format(error_msg, xsdfile.getName());
				log.debug(error_msg);
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			code=InterStatusCode.USER_DEFINDES_ERROR;
			
		}
		
		return code;
	}
	
	private boolean XmlToJsonSign  =  false ;

	private InterStatusCode ProcessXsd(String key,String context){
		InterStatusCode code = InterStatusCode.SUCCESS;
		if(!Strings.isNullOrEmpty(context)){
		
			XSLTEntry entry = new XSLTEntry();
			entry.setXsltid(key);

			Source xslSource = new StreamSource(new StringReader(context)); 
		    TransformerFactory transFact = TransformerFactory.newInstance();
		    try {
				Templates templates = transFact.newTemplates(xslSource);
				entry.setTemplates(templates);
				xsltmapHashMap.put(entry.getXsltid(), entry);
			} catch (TransformerConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				code=InterStatusCode.USER_DEFINDES_ERROR;
				error_msg = "key是[%s],内容为null！";
				
				log.debug(String.format(error_msg, key));
			}       
		}else{
			error_msg = "key是[%s],内容为null！";
			code=InterStatusCode.USER_DEFINDES_ERROR;
			log.debug(String.format(error_msg, key));
		}
		return code;
	}
	
	public String BusiProecess(Object obj,String tablename,String id,List<smParamNode> list){
		String reqcontext = null;
		
		if(Strings.isNullOrEmpty(id)|| obj==null){
			return reqcontext ;
		}
		
		XSLTEntry entry = xsltmapHashMap.get(id);
		if(entry!=null){
			String xmlcontext ;
			if(!(obj instanceof String)){
				xmlcontext = XmlOper.bean2Xml(obj);
			}else{
				xmlcontext = obj.toString();
			}
			
			if(!Strings.isNullOrEmpty(xmlcontext)){
				
				String cur_error_msg = "[%s]";
				String.format(cur_error_msg, reqcontext);
				log.debug(error_msg);
				
				try {
					Transformer transformer = entry.getTemplates().newTransformer();
					if(list!=null&&list.size()>0){
						for(smParamNode node : list){
							if(!Strings.isNullOrEmpty(node.getKey())){
								if(Strings.isNullOrEmpty(tablename)){
									transformer.setParameter(node.getKey(), node.getValue());
									
								}else {
									String keyString =tablename + "." +node.getKey() ; 
									
									transformer.setParameter(keyString.trim(), node.getValue());
								}
								
								//log.debug(String.format("key:[%s],value:[%s]", node.getKey(),node.getValue()));
							}
						}
					}
					transformer.setOutputProperty(OutputKeys.ENCODING, RoadWayConstants.DEFAULT_ENCODING);
					Source xmlSource = new StreamSource(new StringReader(xmlcontext));
				    StringWriter stringWriter = new StringWriter();
				    Result result = new StreamResult(stringWriter);
				    transformer.transform(xmlSource, result);
				    reqcontext = stringWriter.getBuffer().toString();
				    stringWriter.close();
				    
				} catch(Exception e){
					log.error("XML转换错误", e);
				}
			}
		}
		
		return reqcontext;
	}
	
	private HashMap<String, XSLTEntry> xsltmapHashMap = Maps.newHashMap();
	
	private XSLTEntry xmlToJsonEntry = new XSLTEntry();
	
	private String  XMLTOJSONENTRY_KEY = "JSON"; 
	
	private  class XSLTEntry
	{
	   public String getXsltid() {
			return xsltid;
		}

		public void setXsltid(String xsltid) {
			this.xsltid = xsltid;
		}

		public Templates getTemplates() {
			return templates;
		}

		public void setTemplates(Templates templates) {
			this.templates = templates;
		}

		private String xsltid ;
		private Templates templates;
	}
	
	
	 /**
     * @param xmlFile
     * @param xsltFile
     * @return
     * @throws TransformerFactoryConfigurationError
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
    public static OutputStream soap2xml(File xmlFile, File xsltFile)
            throws TransformerFactoryConfigurationError,
            TransformerConfigurationException, TransformerException {
        // JAXP reads data using the Source interface
        Source xmlSource = new StreamSource(xmlFile);
        Source xsltSource = new StreamSource(xsltFile);

        // the factory pattern supports different XSLT processors
        TransformerFactory transFact =
                TransformerFactory.newInstance();
        Transformer trans = transFact.newTransformer(xsltSource);
        
        OutputStream out = new ByteArrayOutputStream();
       // trans.transform(xmlSource, new StreamResult(System.out));
        trans.transform(xmlSource, new StreamResult(out));
        return out;
    }
    
    /**
     * xml文件通过xslt进行转换
     * @param xmlFile 需要进行转换的xml文件
     * @param xmlFile 需要进行转换的xml文件
     * @return out 转换后的结果
     */
    public static OutputStream transform(File xmlFile, File xsltFile)
            throws TransformerFactoryConfigurationError,
            TransformerConfigurationException, TransformerException {
        // JAXP reads data using the Source interface
        Source xmlSource = new StreamSource(xmlFile);
        Source xsltSource = new StreamSource(xsltFile);

        // the factory pattern supports different XSLT processors
        TransformerFactory transFact =
                TransformerFactory.newInstance();
        Transformer trans = transFact.newTransformer(xsltSource);
        
        OutputStream out = new ByteArrayOutputStream();
       // trans.transform(xmlSource, new StreamResult(System.out));
        trans.transform(xmlSource, new StreamResult(out));
        return out;
    }
	
	
	private String error_msg;
	public String getError_msg() {
		return error_msg;
	}

	/**
	 * @return the isInitSign
	 */
	public boolean isInitSign()
	{
		return isInitSign;
	}

	/**
	 * @param isInitSign the isInitSign to set
	 */
	public void setInitSign(boolean isInitSign)
	{
		this.isInitSign = isInitSign;
	}
}
