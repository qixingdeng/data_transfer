package cn.cttic.roadtransapi.common;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XmlBuilder {
	
    public XmlBuilder(String context,boolean sign)
    {
    	if(sign){
    		this.path=context;
            init();
    	}else{
    		 this.context = context;
    		 buildDocument(context);
             buildRoot();
    	}
        
    }
    
    public XmlBuilder()
    {
      
    	
    }
     
    public void init()
    {
        buildDocument();
        buildRoot();
    }
     
   
    private void buildDocument()
    {
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        try
        {
            DocumentBuilder builder=factory.newDocumentBuilder();
            doc=builder.parse(new File(path));            
        }catch(ParserConfigurationException e){
        	 e.printStackTrace();
        }catch(SAXException e){
        	 e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
     
    private void buildDocument(String context)
    {
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        try
        {
            DocumentBuilder builder=factory.newDocumentBuilder();
            
            InputSource is = new InputSource( new StringReader( context ));
            doc=builder.parse(is);    
            
        }catch(ParserConfigurationException e){
        	 e.printStackTrace();
        }catch(SAXException e){
        	 e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void buildRoot()
    {
        root=doc.getDocumentElement();
    }
     
   
    public Document getDoc()
    {
        return doc;
    }
    
    public void setDoc(Document doc)
    {
        this.doc = doc;
    }
   
    public String getPath()
    {
        return path;
    }
   
    public void setPath(String path)
    {
        this.path = path;
    }
    
    public Element getRoot()
    {
        return root;
    }
    
    public void setRoot(Element root)
    {
        this.root = root;
    }
    
    public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	private String path=null;//xml文件路径
    private Document doc=null;//xml文件对应的document
    private Element root=null;//xml文件的根结点
    
    private String context = null;
}
