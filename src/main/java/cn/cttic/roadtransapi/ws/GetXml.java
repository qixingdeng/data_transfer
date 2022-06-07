package cn.cttic.roadtransapi.ws;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class GetXml {
	private String fileUrl = null;

	public String getFileUrl() {
		return fileUrl;
	}

	public GetXml(String file) {
		//this.fileUrl = GetXml.getPath(file);
		this.fileUrl = file;
	}

	/**
	 * 获得项目所在路径
	 * 
	 * @return String
	 */
	public static String getPath(String filename) {
		URL url = GetXml.class.getResource("");
		File file = new File(url.getFile());
		String path = file.getParent();
		while (-1 != path.lastIndexOf("bin") || -1 != path.lastIndexOf(".jar")) {
			file = new File(path);
			path = file.getParent();
		}
		if (path.startsWith("file")) {
			path = path.replaceAll("file:", "");
		}

		path = path + File.separator + "imp\\" + filename;
		path = "C:\\Program Files\\Apache Software Foundation\\Tomcat 5.5\\webapps\\sfzc\\WEB-INF\\classes\\com\\sfzc\\books\\service\\imp\\"
				+ filename;
		return path;
	}

	public String xmlToString() {
		Document document = null;
		document = this.load();

		Format format = Format.getPrettyFormat();
		format.setEncoding("UTF-8");// 设置编码格式

		StringWriter out = null; // 输出对象
		String sReturn = ""; // 输出字符串
		XMLOutputter outputter = new XMLOutputter();
		out = new StringWriter();
//		try {
//			outputter.output(document, out);
//			sReturn = out.toString();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				out.flush();
//				out.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		sReturn = outputter.outputString(document);
		
		return sReturn;
	}
	
	public Document load() {
		Document document = null;
		String url = this.getFileUrl();
		try {
			SAXBuilder reader = new SAXBuilder();
			document = reader.build(new File(url));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return document;
	}
	
	public String removeLineTab(String xmlContent) {
		//Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		Pattern p = Pattern.compile("\t|\r|\n");
		Matcher m = p.matcher(xmlContent);
		return m.replaceAll("");
	}

}
