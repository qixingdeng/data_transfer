package cn.cttic.roadtransapi.mgr;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.Collections;
import java.util.Date;
import java.util.EventListener;
import java.util.EventObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import cn.cttic.roadtransapi.code.InterStatusCode;
import cn.cttic.roadtransapi.common.PageParamInfo;
import cn.cttic.roadtransapi.common.PrimaryKeyAttr;
import cn.cttic.roadtransapi.common.RoadWayServiceRoot;
import cn.cttic.roadtransapi.common.SelectParamRoot;
import cn.cttic.roadtransapi.common.SelectValBySequence;
import cn.cttic.roadtransapi.common.SelectWhereParam;
import cn.cttic.roadtransapi.common.StringUtil;
import cn.cttic.roadtransapi.common.TableValueOper;
import cn.cttic.roadtransapi.common.UnionPrimaryKeyAttr;
import cn.cttic.roadtransapi.common.XmlOper;
import cn.cttic.roadtransapi.common.smParamNode;
import cn.cttic.roadtransapi.constants.DBOperType;
import cn.cttic.roadtransapi.constants.DB_EXAMPLE_OPER_TYPE;
import cn.cttic.roadtransapi.constants.DB_MAPPER_OPER_TYPE;
import cn.cttic.roadtransapi.domain.InterSpcAttr;
import cn.cttic.roadtransapi.domain.InterSpcSignature;
import cn.cttic.roadtransapi.domain.InterSwapPlatformConfigWithBLOBs;
import cn.cttic.roadtransapi.orm.waterway.domain.CertiAttrRela;
import cn.cttic.roadtransapi.orm.waterway.domain.VoluPriceInfo;
import cn.cttic.sysframe.common.util.DateUtil;
import cn.cttic.sysframe.common.util.SpringContextUtil;
import cn.cttic.sysframe.frame.dao.SystemMapper;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
public class DBMgr  {
	
	public DBMgr(){
		Init();
	}
	
	private static DBMgr dbMgrService = null;
	
	public static DBMgr getInstance() {
	    if (dbMgrService == null) {
	    	dbMgrService = (DBMgr)SpringContextUtil.getBean("dbMgrService");
	       }
	       return dbMgrService;   
	}
	
	private static String log_table_format = DateUtil.PATTERNYYYYMMDD;
	
	private static Logger log = Logger.getLogger(DBMgr.class);
	
	private Properties interProperties = null;
	
	public static void reload(){
		if (dbMgrService == null) {
	    	dbMgrService = (DBMgr)SpringContextUtil.getBean("dbMgrService");
	       }
		log.info("reload config.....");
		dbMgrService.configmapMap.clear();
		dbMgrService.attrconfigmapMap.clear();
		dbMgrService.configBusiConfigRoleMap.clear();
		dbMgrService.Init();
		XMLTransformerMgr.getInstance().setInitSign(false);
		XMLTransformerMgr.getInstance();
		log.info("reload config.....end");
	}
	
	@SuppressWarnings("unchecked")
	private void Init(){
		
		String classpath = DBMgr.class.getResource("/").getPath();
		String bpmProp = classpath + "data/busi.properties";
		FileInputStream fis;
		Properties prop = new Properties();
		try {
			fis = new FileInputStream(bpmProp);
			prop.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			log.debug(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.debug(e);
		}
		
		interProperties = prop;
		
		DB_DOMAIN = interProperties.getProperty("db.db_domain.package");
		DB_DAO = interProperties.getProperty("db.db_dao.package");
		
		if(!DB_DOMAIN.substring(DB_DOMAIN.length() -1).equals(".")){
			DB_DOMAIN = DB_DOMAIN + ".";
		}
		
		
		if(!DB_DAO.substring(DB_DAO.length() -1).equals(".")){
			DB_DAO = DB_DAO + ".";
		}
		
		
		DB_INTER_DOMAIN = interProperties.getProperty("db.db_domain.inter");
		DB_INTER_DAO = interProperties.getProperty("db.db_dao.inter");
		
		if(Strings.isNullOrEmpty(DB_INTER_DOMAIN)){
			DB_INTER_DOMAIN = "cn.cttic.roadtransapi.domain";
		}
		
		if(Strings.isNullOrEmpty(DB_INTER_DAO)){
			 DB_INTER_DAO = "cn.cttic.roadtransapi.dao";
		}
		
		
		if(!DB_INTER_DOMAIN.substring(DB_INTER_DOMAIN.length() -1).equals(".")){
			DB_INTER_DOMAIN = DB_INTER_DOMAIN + ".";
		}
		
		
		if(!DB_INTER_DAO.substring(DB_INTER_DAO.length() -1).equals(".")){
			DB_INTER_DAO = DB_INTER_DAO + ".";
		}
		
		
		ExampleData configdataData = GetExampleData("InterSwapPlatformConfig");
		
		if(configdataData!=null){
			Object list = configdataData.selectByExampleWithBLOBs(null);
			if(list!=null){
				List<Object> objlist = (List<Object>) list;
				for (Object object : objlist) {
					
					if(object.getClass().getName().equals(InterSwapPlatformConfigWithBLOBs.class.getName())){
						configlist.add((InterSwapPlatformConfigWithBLOBs)object);
					}else {
						InterSwapPlatformConfigWithBLOBs bloBs = new InterSwapPlatformConfigWithBLOBs();
						TableValueOper.SetValue(bloBs, object);
						configlist.add(bloBs);
					}
					
				}
				
				String temp = "配置表[INTER_SWAP_PLATFORM_CONFIG]中，含有数据[%d]条";
				temp =String.format(temp, configlist.size());
				log.debug(temp);
				
				for(InterSwapPlatformConfigWithBLOBs config : configlist){
			    	configmapMap.put(config.getSystemId() + config.getServiceId(), config);
			    }
				
				
			}
		}
		
		
		configdataData = GetExampleData("InterSpcAttr");
		
		if(configdataData!=null){
			Object list = configdataData.selectByExampleWithBLOBs(null);
			if(list!=null){
				List<Object> objlist = (List<Object>) list;
				for (Object object : objlist) {
					
					if(object.getClass().getName().equals(InterSpcAttr.class.getName())){
						attrlist.add((InterSpcAttr)object);
					}else {
						InterSpcAttr bloBs = new InterSpcAttr();
						TableValueOper.SetValue(bloBs, object);
						attrlist.add(bloBs);
					}
					
				}
				
				for(InterSpcAttr config : attrlist){
					attrconfigmapMap.put(config.getId(), config);
			    }
				
			}
		}
		
		initConfigRole();
		
		configdataData = GetExampleData("InterSpcSignature");
		
		if(configdataData!=null){
			Object list = configdataData.selectByExample(null);
			if(list!=null){
				
				List<Object> objlist = (List<Object>) list;
				for (Object object : objlist) {
					if(object.getClass().getName().equals(InterSpcSignature.class.getName())){
						infolist.add((InterSpcSignature)object);
					}else {
						InterSpcSignature bloBs = new InterSpcSignature();
						TableValueOper.SetValue(bloBs, object);
						infolist.add(bloBs);
					}
				}
				
				
			}
		}
			
		
		
		String signString = interProperties.getProperty("rest.sign");
		if(Strings.isNullOrEmpty(signString)){
			signString = "0";
		}
		

		String scanf_timespace = interProperties.getProperty("rest.scanf_timespace");
		if(Strings.isNullOrEmpty(scanf_timespace)){
			scanf_timespace = "3000";
		}
		String scanf_timeout = interProperties.getProperty("rest.scanf_timeout");
		if(Strings.isNullOrEmpty(scanf_timeout)){
			scanf_timeout = "3000";
		}
		
		String format = interProperties.getProperty("date_format");
		if(Strings.isNullOrEmpty(format)){
			date_format = DateUtil.PATTERN_YYYY_MM_DD_HH_MM_SS;
		}
		
		String ip = interProperties.getProperty("cache.ip");
		if(Strings.isNullOrEmpty(ip)){
			ip="127.0.0.1";
		}
		
		
		String port = interProperties.getProperty("cache.port");
		if(Strings.isNullOrEmpty(port)){
			port = "6379";
		}
		
		String logsign = interProperties.getProperty("log.sign");
		if(Strings.isNullOrEmpty(port)){
			port = "0";
		}
		
		
		String mapinit = interProperties.getProperty("map.init");
		if(Strings.isNullOrEmpty(mapinit)){
			mapinit = "0";
		}
		
		log_dataload_sign=logsign;
		date_format=format;
		rest_Sign = signString;
		rest_scanf_timespace = scanf_timespace;
		rest_scanf_timeout = scanf_timeout;
		cache_ip  = ip ; 
		cache_port = port;
		map_init = mapinit;
		
		dbSource = new DBEventSource();
		
		DBDMLEventListener listener = new DBDMLEventListener();
		
		dbSource.registerObserver(listener);
		
		
		
		// sort configBusiConfigRoleMap
		sortConfigBusiConfigRoleMap();
	}
	
	
	private void sortConfigBusiConfigRoleMap(){
		for(Map.Entry<String, BusiConfigRole> entry:configBusiConfigRoleMap.entrySet()){    
			BusiConfigRole tempBusiConfigRole = entry.getValue();
			if(tempBusiConfigRole!=null &&tempBusiConfigRole.getSubmapperlist().size() >0){
				List<BusiConfigRole>  list = tempBusiConfigRole.getSubmapperlist();
				Collections.sort(list);;
			}
		}   
		
	}
	
	private String cache_ip;
	private String cache_port;
	
	private String date_format ;
	
	private String rest_Sign = "";
	
	private String log_dataload_sign="0";
	
	private String map_init ;
	
	public String getLog_dataload_sign() {
		return log_dataload_sign;
	}


	
	public String getRest_Sign() {
		return rest_Sign;
	}

	public String getCache_ip() {
		return cache_ip;
	}


	public String getCache_port() {
		return cache_port;
	}




	public String getRest_scanf_timespace() {
		return rest_scanf_timespace;
	}


	public String getRest_scanf_timeout() {
		return rest_scanf_timeout;
	}

	private String rest_scanf_timespace = "";
	private String rest_scanf_timeout = "";
	
	public InterSwapPlatformConfigWithBLOBs GetConfig(String servicetype , String serviceid){
		InterSwapPlatformConfigWithBLOBs config = null;
		String configkey=servicetype+serviceid;
		config = configmapMap.get(configkey);
		return config;
	}
	
	
	public InterSwapPlatformConfigWithBLOBs GetConfig(String configkey){
		InterSwapPlatformConfigWithBLOBs config = null;
		
		config = configmapMap.get(configkey);
		return config;
	}
	
		
	private SystemMapper systemMapper = SpringContextUtil.getBean(SystemMapper.class);
	
	private Map<String, InterSpcAttr> attrconfigmapMap = Maps.newHashMap();
	private Map<String, InterSwapPlatformConfigWithBLOBs> configmapMap = Maps.newHashMap();
	
	private List<InterSwapPlatformConfigWithBLOBs> configlist= Lists.newArrayList();
	private List<InterSpcAttr> attrlist =  Lists.newArrayList();
	private List<InterSpcSignature> infolist =  Lists.newArrayList();
	
	public List<InterSpcSignature> getInfolist() {
		return infolist;
	}

	
	
	public List<InterSpcAttr> getAttrConfiglist() {
		return attrlist;
	}
	

	public List<InterSwapPlatformConfigWithBLOBs> getConfiglist() {
		return configlist;
	}
	
	private static String XML_CONTEXT = "<?xml version=\"1.0\" encoding=\"utf-8\"?><sample></sample>";
	private InterStatusCode ProcessService(String key ,String  Selectxml ,smParamNode resultlist, RoadWayServiceRoot resultParamRoot){
		InterStatusCode ret = InterStatusCode.NUKONW_ERROR;
		String temp;
		SelectParamRoot root = (SelectParamRoot) XmlOper.xml2Bean(SelectParamRoot.class, Selectxml);
		if(root==null){
			ret=InterStatusCode.GET_DBCONFIG_TR_ERROR;
			log.debug(ret.getDescription());
		}else{
			String table_name = root.getMappername();
			String classname = table_name;
		    temp = "key:[%s] mapper:[%s]中，关联表有:[%s]";
			temp = String.format(temp, key,classname,root.getTablename());
			int index = -1 ; 
			String[] splitstrStrings = key.split("_");
			if(!Strings.isNullOrEmpty(splitstrStrings[1])){
				index = Integer.parseInt(splitstrStrings[1]);
			}else{
				index = 0 ;
			}
			
			
			log.debug(temp);
			
			Object example = CreateExample(classname,root);
			if(example!=null){
				ExampleData data=GetExampleData(classname);
				Object resultObject = null;
				if(index>0 || root.getPageInfo() == null){
					resultObject = data.selectByExample(example);
				}else{ 
					resultObject = data.select(example,root.getPageInfo());
				}
				
				if(resultObject!=null){
					// 递归
					resultlist.setId(table_name);
					ret = CreateResult(root,resultlist.getSmParamNode(),resultObject);
					if(ret==InterStatusCode.SUCCESS){

						BusiConfigRole role =  configBusiConfigRoleMap.get(key) ;
						if(role == null){
							ret=InterStatusCode.GET_REQ_SUB_ERROR;
							ret.setTempString(String.format(ret.getDescription(), key));
							log.debug(ret.getTempString());
						}else{
							List<BusiConfigRole>  roolelist = role.getSubmapperlist();
							for(BusiConfigRole subrole : roolelist){
								
								String curkeyString=XMLTransformerMgr.CLIENT_SPC_ATTR+"_"+subrole.getId();
								String cursign = subrole.getIstablename();
								
								for(smParamNode subNode : resultlist.getSmParamNode()){
									if("pageinfo".equals(subNode.getId())){
										continue;
									}
									
									String curcontext = "";
									if(Strings.isNullOrEmpty(cursign) || cursign.equals("0")){
										curcontext =XMLTransformerMgr.getInstance().BusiProecess(XML_CONTEXT,"", curkeyString, subNode.getSmParamNode()); 
									} else if(cursign.equals("1")){
										String rootcontext = XmlOper.bean2Xml(resultParamRoot);
										//log.debug(String.format("root:[%s]", rootcontext));
										curcontext =XMLTransformerMgr.getInstance().BusiProecess(rootcontext,"", curkeyString, subNode.getSmParamNode()); 
										//log.debug(String.format("curcontext:[%s][%s]",table_name, curcontext));
									} else {
										curcontext =XMLTransformerMgr.getInstance().BusiProecess(XML_CONTEXT,table_name, curkeyString, subNode.getSmParamNode()); 
									}
									
									if(Strings.isNullOrEmpty(curcontext)){
								    	ret=InterStatusCode.GET_REQ_SUB_PROCESS_ERROR;
										ret.setTempString(String.format(ret.getDescription(), key));
										log.debug(ret.getTempString());
										//subNode.getSmParamNode().clear();
										continue;
								    }else{
								    	smParamNode newNode = new smParamNode();
										ret=ProcessService(subrole.getKey(),curcontext,newNode,resultParamRoot);
										if(ret==InterStatusCode.SUCCESS){
											subNode.getSmParamNode().add(newNode);
										}else{
											if(Strings.isNullOrEmpty(ret.getTempString())){
												log.debug(ret.getDescription());
											}else {
												log.debug(ret.getTempString());
											}
											
											//subNode.getSmParamNode().clear();
											continue;
										}
										
								    }
									
			
								}
								
							}
						}
						
					}
				}else{
					ret=InterStatusCode.PARSE_RESULT_ERROR;
					ret.setTempString(String.format(ret.getDescription(), classname));
					log.debug(ret.getTempString());
				}
			}else{
				ret=InterStatusCode.PARSE_EXAMPLE_ERROR;
				ret.setTempString(String.format(ret.getDescription(), classname));
				log.debug(ret.getTempString());
			}
		}
		return ret ;
	}
	
	public InterStatusCode ProcessBusi(String key , String reqcontext ,StringBuffer context){
		InterStatusCode ret = InterStatusCode.NUKONW_ERROR;
		String temp;
		
		RoadWayServiceRoot resultParamRoot= new RoadWayServiceRoot();
		ret = ProcessService(key,reqcontext,resultParamRoot.getSmParamNode(),resultParamRoot);
		if(ret==InterStatusCode.SUCCESS){
			String xmlcontext = XmlOper.bean2Xml(resultParamRoot);
			
		    temp = "得到的xml是[%s]";
		    temp=String.format(temp, xmlcontext);
			log.debug(temp);
			
			if(!Strings.isNullOrEmpty(xmlcontext)){
				context.append(xmlcontext);
			}
		}
		
		
		return ret;
	}
	
	
	public InterStatusCode ProcessBusiForChose(String key , String reqcontext ,StringBuffer context){
		InterStatusCode ret = InterStatusCode.NUKONW_ERROR;
		DBEvent event  = new DBEvent(reqcontext);
		event.setRespBuffer(context);
		dbSource.notifyAllObservers(event);
		ret = event.getCode();
		return ret;
	}
	
	public InterStatusCode ProcessBusiForModify(String key , String reqcontext ,StringBuffer context){
		InterStatusCode ret = InterStatusCode.NUKONW_ERROR;
		String temp;
		
		RoadWayServiceRoot root = (RoadWayServiceRoot) XmlOper.xml2Bean(RoadWayServiceRoot.class, reqcontext);
		if(root!=null){
			RoadWayServiceRoot resultParamRoot= new RoadWayServiceRoot();
			
			try {
				Map<String,String> commandmap = Maps.newHashMap(); //map存放多个对象中需要传递的值
				ret = ProcessServiceForModify(key,root.getSmParamNode(),commandmap);
			} catch (Exception e) {
				log.debug(e);
			}
			
			if(ret==InterStatusCode.SUCCESS){
				String xmlcontext = XmlOper.bean2Xml(resultParamRoot);
			    temp = "得到的xml是[%s]";
			    temp=String.format(temp, xmlcontext);
				log.debug(temp);
				
				if(!Strings.isNullOrEmpty(xmlcontext)){
					context.append(xmlcontext);
				}
			}
		}else{
			ret=InterStatusCode.PARSE_MODIFY_REQ_ERROR;
			ret.setTempString(String.format(ret.getDescription(), key));
			log.debug(ret.getTempString());
		}
		
		
		
		return ret;
	}
	
	private InterStatusCode ProcessServiceForModify(String key ,smParamNode resultlist,Map<String,String> commandmap) throws Exception{
		InterStatusCode ret = InterStatusCode.NUKONW_ERROR;
//		try {
			// 递归
			List<smParamNode> list = resultlist.getSmParamNode();
			for(smParamNode sNode : list){
				if(sNode.getSmParamNode().size() >0){
					String classname = sNode.getId();
					if(!Strings.isNullOrEmpty(classname)){
						log.debug(String.format("Process data : [%s]", sNode.getId()));
						ExampleData data=GetExampleData(classname);
						
						if(data!=null){
							ret= data.insert(sNode.getSmParamNode(), commandmap);
						}else{
							throw new Exception();
						}
					}else{
						throw new Exception();
					}
					
				}
			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			ret=InterStatusCode.PARSE_MODIFY_SQL_ERROR;
//			ret.setDescription(String.format(ret.getDescription(), e.getMessage()));
//			log.debug(ret.getDescription());
//			throw e;
//		}
		return ret;
	}
	
	public InterStatusCode ProcessServiceInsertOrUpdate(String key, String reqcontext, StringBuffer context) throws Exception {
		InterStatusCode ret = InterStatusCode.NUKONW_ERROR;
		String temp;

		RoadWayServiceRoot root = (RoadWayServiceRoot) XmlOper.xml2Bean(
				RoadWayServiceRoot.class, reqcontext);
		if (root != null) {
			RoadWayServiceRoot resultParamRoot = new RoadWayServiceRoot();
			ret = ProcessServiceInsertOrUpdate(key, root.getSmParamNode());
			if (ret == InterStatusCode.SUCCESS) {
				String xmlcontext = XmlOper.bean2Xml(resultParamRoot);
				temp = "得到的xml是[%s]";
				temp = String.format(temp, xmlcontext);
				log.debug(temp);

				if (!Strings.isNullOrEmpty(xmlcontext)) {
					context.append(xmlcontext);
				}
			}
		} else {
			ret = InterStatusCode.PARSE_MODIFY_REQ_ERROR;
			ret.setTempString(String.format(ret.getDescription(), key));
			log.debug(ret.getTempString());
		}
		return ret;
	}
	
	private InterStatusCode ProcessServiceInsertOrUpdate(String key, smParamNode resultlist) throws Exception {
		InterStatusCode ret = InterStatusCode.NUKONW_ERROR;
		// 递归
		List<smParamNode> list = resultlist.getSmParamNode();
		for (smParamNode sNode : list) {
			if (sNode.getSmParamNode().size() > 0) {
				String classname = sNode.getId();
				if (!Strings.isNullOrEmpty(classname)) {
					classname = classname.replaceFirst(classname.substring(0, 1),classname.substring(0, 1).toUpperCase())  ;
					log.debug(String.format("Process data : [%s]", sNode.getId()));
					ExampleData data = GetExampleData(classname);

					if (data != null) {
						ret = data.insertOrUpdate(sNode.getSmParamNode());
					} else {
						throw new Exception();
					}
				} else {
					throw new Exception();
				}
			}
		}
		return ret;
	}
	
	public InterStatusCode ProcessBusiForSmallTee(String key, String reqcontext, StringBuffer context)  throws Exception {
		InterStatusCode ret = InterStatusCode.NUKONW_ERROR;
		String temp;

		RoadWayServiceRoot root = (RoadWayServiceRoot) XmlOper.xml2Bean(RoadWayServiceRoot.class, reqcontext);
		if (root != null) {
			RoadWayServiceRoot resultParamRoot = new RoadWayServiceRoot();
			
			Map<String,String> commandmap = Maps.newHashMap(); //map存放多个对象中需要传递的值
			ret = ProcessServiceForSmallTee(key, root.getSmParamNode(), commandmap);
			
			if (ret == InterStatusCode.SUCCESS) {
				String xmlcontext = XmlOper.bean2Xml(resultParamRoot);
				temp = "得到的xml是[%s]";
				temp = String.format(temp, xmlcontext);
				log.debug(temp);

				if (!Strings.isNullOrEmpty(xmlcontext)) {
					context.append(xmlcontext);
				}
			}
		} else {
			ret = InterStatusCode.PARSE_MODIFY_REQ_ERROR;
			ret.setTempString(String.format(ret.getDescription(), key));
			log.debug(ret.getTempString());
		}
		return ret;
	}
	
	private InterStatusCode ProcessServiceForSmallTee(String key, smParamNode resultlist, Map<String,String> commandmap) throws Exception {
		InterStatusCode ret = InterStatusCode.NUKONW_ERROR;
		// 递归
		List<smParamNode> list = resultlist.getSmParamNode();
		for (smParamNode sNode : list) {
			if (sNode.getSmParamNode().size() > 0) {
				String classname = sNode.getId();
				if (!Strings.isNullOrEmpty(classname)) {
					classname = classname.replaceFirst(classname.substring(0, 1),classname.substring(0, 1).toUpperCase())  ;
					log.debug(String.format("Process data : [%s]", sNode.getId()));
					ExampleData data = GetExampleData(classname);

					if (data != null) {
						ret = data.insertSmallTee(sNode.getSmParamNode(), commandmap);
					} else {
						throw new Exception();
					}
				} else {
					throw new Exception();
				}
			}
		}
		return ret;
	}
		
	@SuppressWarnings("unchecked")
	private InterStatusCode CreateResult(SelectParamRoot selectroot,List<smParamNode> list,Object resultObject){
		InterStatusCode ret = InterStatusCode.NUKONW_ERROR;
		List<Object> varlist = null;
		smParamNode temp = null;
		List<String> colouelist = selectroot.getColumn();
		if(resultObject instanceof List){
			if (resultObject.getClass().getSimpleName().equals("PageList")) {
				PageList<Object> pagelist = (PageList<Object>) resultObject;
				for (Object obj : pagelist) {
					temp = CreatesmParamNode(colouelist,obj);
					if(temp!=null){
						list.add(temp);
					}else{
						ret=InterStatusCode.PARSE_RESULT_RESP_ERROR;
						ret.setTempString(String.format(ret.getDescription(), selectroot.getMappername()));
						log.debug(ret.getTempString());
						list.clear();
						return ret;
					}
					
				}
				
				// Page
				
				smParamNode rootNode = new smParamNode();
				rootNode.setId("pageinfo");
				
				smParamNode temParamNode=null;
				
				temParamNode =  new smParamNode();
				temParamNode.setKey("limit");
				temParamNode.setValue(Integer.toString(pagelist.getPaginator().getLimit()));
				rootNode.getSmParamNode().add(temParamNode);
				
				
				temParamNode =  new smParamNode();
				temParamNode.setKey("page");
				temParamNode.setValue(Integer.toString(pagelist.getPaginator().getPage()));
				rootNode.getSmParamNode().add(temParamNode);
				
				
				temParamNode =  new smParamNode();
				temParamNode.setKey("totalcount");
				temParamNode.setValue(Integer.toString(pagelist.getPaginator().getTotalCount()));
				rootNode.getSmParamNode().add(temParamNode);
				
				
				temParamNode =  new smParamNode();
				temParamNode.setKey("totalpages");
				temParamNode.setValue(Integer.toString(pagelist.getPaginator().getTotalPages()));
				rootNode.getSmParamNode().add(temParamNode);
				
				list.add(rootNode);
				
			}else{
				varlist = (List<Object>) resultObject;
				for (Object obj : varlist) {
					temp = CreatesmParamNode(colouelist,obj);
					if(temp!=null){
						list.add(temp);
					}else{
						ret=InterStatusCode.PARSE_RESULT_RESP_ERROR;
						ret.setTempString(String.format(ret.getDescription(), selectroot.getMappername()));
						log.debug(ret.getTempString());
						list.clear();
						return ret;
					}
					
				}
			}
		}else{
			temp = CreatesmParamNode(colouelist,resultObject);
			if(temp!=null){
				list.add(temp);
			}
		}
		
		ret = InterStatusCode.SUCCESS;
		return ret;
	}
	
	private smParamNode CreatesmParamNode(List<String> colouelist,Object linedata){
		smParamNode temp = null;
		ExampleData data=GetExampleData(linedata.getClass().getSimpleName());
		smParamNode rootNode = new smParamNode();
		if(data == null){
			return temp;
		}
		
		Object resultstr = null;
		for(String name : colouelist){
			
			 temp = new smParamNode();
			 temp.setKey(name);
			 resultstr = data.GetValue(linedata, name);
			 if(resultstr==null){
				 temp.setValue("");
			 }else{
				 if(resultstr instanceof Date){
					 java.util.Date curDate =(Date) resultstr;
					 
					 temp.setValue(DateUtil.format(curDate, date_format));
				 }else{
					 temp.setValue(resultstr.toString());
				 }
				 
			 }
			 rootNode.getSmParamNode().add(temp);
		}
		return rootNode;
	}
	
	private Object CreateExample(String classname,SelectParamRoot root ) {
		Object example = null;
		
		ExampleData data=GetExampleData(classname);
		if(data != null){
			example = data.newExample(root);
		}
		
		return example;
	}
	
	private ExampleData GetExampleData(String classname){
		ExampleData data=exampleMap.get(classname);
		if(data == null){
			data = new ExampleData(classname);
			if(data.isAccess()){
				exampleMap.put(data.getKey(), data);
			}else{
				log.debug(data.getMsg());
			}
		}
		
		return data;
	}
	
	private String DB_DOMAIN ;
	private String DB_DAO ;
	
	
	private  String  DB_INTER_DOMAIN ;
	private  String  DB_INTER_DAO ;
	
	
	private  String  SYS_FRAME_DOMAIN = "cn.cttic.sysframe.frame.domain." ;
	private  String  SYS_FRAME_DAO = "cn.cttic.sysframe.frame.dao." ;
	
	private Map<String, ExampleData> exampleMap = Maps.newHashMap();
	
	private class ExampleData{
		public ExampleData(String classname){
			key = classname;
			String examplenameString=GetExampleFullname();
			String mappernameString=GetMapperFullname();
			try {
				Class<?> exampleclass = null ;
				
				if(classname.toLowerCase().startsWith("inter")){
					exampleclass = Class.forName(DB_INTER_DOMAIN+examplenameString);
					mapperClass = Class.forName(DB_INTER_DAO+mappernameString);
					classtype = exampleclass;
					daoClass = Class.forName(DB_INTER_DOMAIN+key);
				} else if (classname.toLowerCase().equals("smparamdetail")) {
					exampleclass = Class.forName(SYS_FRAME_DOMAIN+examplenameString);
					mapperClass = Class.forName(SYS_FRAME_DAO+mappernameString);
					classtype = exampleclass;
					daoClass = Class.forName(SYS_FRAME_DOMAIN+key);
				}else {
					exampleclass = Class.forName(DB_DOMAIN+examplenameString);
					mapperClass = Class.forName(DB_DAO+mappernameString);
					classtype = exampleclass;
					daoClass = Class.forName(DB_DOMAIN+key);
				}
				
				
				
				
				Method [] mapperMethods = mapperClass.getMethods();
			    
				for(Method method:mapperMethods){
					mappermethodMap.put(method.getName(), method);
				}
				
				
			    selectByExample = mappermethodMap.get("selectByExample");
			    countByExample = mappermethodMap.get("countByExample"); 
			    insertSelective = mappermethodMap.get("insertSelective");
			    updateByExampleSelective =  mappermethodMap.get("updateByExampleSelective"); 
			    selectByExampleForPage = mappermethodMap.get("selectByExampleForPage");  
			    selectByExampleWithBLOBs = mappermethodMap.get("selectByExampleWithBLOBs");
			    
			    
			    Object  example = exampleclass.newInstance();
			    createCriteria = classtype.getMethod("createCriteria");
			    Object Criteria = createCriteria.invoke(example);
				criteriaclasstype = Criteria.getClass();
				Method [] arrayMethods = criteriaclasstype.getDeclaredMethods();
				for(Method method:arrayMethods){
					methodMap.put(method.getName(), method);
				}
				
				// add by zhangzechen@20150408 通过注解查找主键
				Field[] arrayFields = daoClass.getDeclaredFields();
				for (Field currField : arrayFields) {
					if(currField.isAnnotationPresent(PrimaryKeyAttr.class)){
						primaryKeyName = currField.getName();
						String attrMethodSet = "and" + primaryKeyName.substring(0,1).toUpperCase() + primaryKeyName.substring(1) + "EqualTo";
						primaryKeySetMethod = criteriaclasstype.getDeclaredMethod(attrMethodSet, currField.getType());
					}
				}
				
				//Method [] arraydaoMethods = daoClass.getDeclaredMethods();
				Method [] arraydaoMethods = daoClass.getMethods();
				for(Method method:arraydaoMethods){
					daomethodMap.put(method.getName(), method);
				}
				
				
				isAccess = true;
			} catch (Exception e) {
				log.debug(e);
				isAccess = false;
				msg="[%s]产生了类型[%s]的异常";
				
				msg=String.format(msg, examplenameString,e.getClass().getSimpleName());
			}
		}
		
		public static final int PAGE_LIMIR = 10;
		
		public  Object selectByExampleWithBLOBs(Object example){
			Object  list = null;
			if(selectByExampleWithBLOBs!=null&&mapperClass!=null){
				Object mapper = getMapper(mapperClass);
				if(mapper!=null){
					try {
						
						list = selectByExampleWithBLOBs.invoke(mapper, example);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						log.debug(e);
						list=null;
						msg="[%s]产生了类型[%s]的异常";
						msg=String.format(msg, key,e.getClass().getSimpleName());
					}
				}
			}
			return list ;
		}
		
		private Object selectByExampleForPagebyPage(Object example , int pageNumber){
			PageList<Object> list = null;
			if(example!=null && selectByExampleForPage!=null&&mapperClass!=null){
				Object mapper = getMapper(mapperClass);
				if(mapper!=null){
					try {
						
						PageBounds pageBounds = new PageBounds();
						pageBounds.setLimit(PAGE_LIMIR);
						pageBounds.setPage(pageNumber);
						pageBounds.setContainsTotalCount(true);
						
						list = (PageList<Object>) selectByExampleForPage.invoke(mapper, example,pageBounds);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						log.debug(e);
						list=null;
						msg="[%s]产生了类型[%s]的异常";
						msg=String.format(msg, key,e.getClass().getSimpleName());
					}
				}
			}
			
			
			return list ;
		}
		
		/**
		 * 根据序列查询id,并以属性名为key，id为value，存放到map中
		 * @param commandmap
		 * @param daoClass
		 */
		private void fillValInMap(Map<String,String> commandmap) {
			Field[] fields = daoClass.getDeclaredFields();
			for (Field field : fields) {
				boolean hasAnnotation = field.isAnnotationPresent(SelectValBySequence.class);
				if(hasAnnotation) {
					SelectValBySequence annotation = field.getAnnotation(SelectValBySequence.class);
					
					//根据序列名称，查找id
					Map<String, String> sequenceMap = new HashMap<String, String>();
					sequenceMap.put("sequenceName", annotation.SequenceName());
					
					Long primaryKeyVal = systemMapper.generateId(sequenceMap);
					
					commandmap.put(field.getName(), String.valueOf(primaryKeyVal));
				}
			}
		}
		
		/**
		 * 填充主键值
		 * @param commandmap
		 * @param daoClass
		 * @throws  
		 * @throws NoSuchFieldException 
		 */
		private void fillPrimaryVal(Map<String,String> commandmap, Object object){
			//查找序列，找到主键id，并设置到实体中
			Field[] fields = daoClass.getDeclaredFields();
			for (Field field : fields) {
				boolean isAnnotation = field.isAnnotationPresent(PrimaryKeyAttr.class);
				if(isAnnotation) {
					SetValue(object, field.getName(), commandmap.get(field.getName()));
					break;
				}
			}
		}
		
		/**
		 * 填充常用字段值
		 * @param commandmap
		 * @param daoClass
		 * @throws  
		 * @throws NoSuchFieldException 
		 */
		private void fillCommonFieldVal(Map<String,String> commandmap, Object object){
			//查找序列，找到主键id，并设置到实体中
			Field[] fields = daoClass.getDeclaredFields();
			for (Field field : fields) {
				if(commandmap.containsKey(field.getName())) {
					SetValue(object, field.getName(), commandmap.get(field.getName()));
				}
			}
		}
		
		private InterStatusCode  insert(List<smParamNode> list,Map<String,String> commandmap) throws Exception{
			InterStatusCode ret = InterStatusCode.NUKONW_ERROR;
			String key ;
			String value ;
			Object object = daoClass.newInstance();
			
			fillValInMap(commandmap); //将根据注解生成的值存放到map中
			//fillPrimaryVal(commandmap, object); //填充主键值
			fillCommonFieldVal(commandmap, object); //填充主键值
			
			for(smParamNode node : list){
				key=node.getKey();
				value =node.getValue();
				
//				if(StringUtils.isBlank(value) && commandmap.containsKey(key)) {
//					value = commandmap.get(key);
//				}
				
				SetValue(object,key,value);
				
			}
			
			Object mapper = getMapper(mapperClass);
			Object countObject = insertSelective.invoke(mapper, object);
			if(Integer.parseInt(countObject.toString()) >0){
				ret = InterStatusCode.SUCCESS;
			}
			return ret ;
		}
		
		// add by zhangzechen@20150408
		private InterStatusCode update(Object example ,List<smParamNode> list) throws Exception {
			InterStatusCode ret = InterStatusCode.NUKONW_ERROR;
			String key ;
			String value ;
			Object object = daoClass.newInstance();
			for(smParamNode node : list){
				key=node.getKey();
				value =node.getValue();
				SetValue(object,key,value);
			}

			Object mapper = getMapper(mapperClass);
			Object countObject = updateByExampleSelective.invoke(mapper, example, object);
			if (Integer.parseInt(countObject.toString()) > 0) {
				ret = InterStatusCode.SUCCESS;
			}
			return ret;
		}
		
		private InterStatusCode insertOrUpdate(List<smParamNode> list) throws Exception {
			InterStatusCode ret = InterStatusCode.NUKONW_ERROR;
			String key;
			String value;
			
			Object object = daoClass.newInstance();
			Object example = classtype.newInstance();
			boolean hasPrimaryKey = StringUtils.isNotEmpty(primaryKeyName);
			int count = 0;

			for (smParamNode node : list) {
				key = node.getKey();
				value = node.getValue();
				SetValue(object, key, value);

				if (hasPrimaryKey && primaryKeyName.equals(key)) {
					Object criteria = createCriteria.invoke(example);
					primaryKeySetMethod.invoke(criteria, Long.valueOf(value));
				}
			}

			if(hasPrimaryKey){
				count = countByExample(example);
			}
			Object mapper = getMapper(mapperClass);
			if (count > 0) {
				Object countObject = updateByExampleSelective.invoke(mapper, object, example);
				if (Integer.parseInt(countObject.toString()) > 0) {
					ret = InterStatusCode.SUCCESS;
				}
			} else {
				Object countObject = insertSelective.invoke(mapper, object);
				if (Integer.parseInt(countObject.toString()) > 0) {
					ret = InterStatusCode.SUCCESS;
				}
			}
			
			return ret;
		}
		
		private InterStatusCode insertSmallTee(List<smParamNode> list, Map<String,String> commandmap) throws Exception {
			InterStatusCode ret = InterStatusCode.NUKONW_ERROR;
			String key;
			String value;
			
			Object object = daoClass.newInstance();
			Object example = classtype.newInstance();
			boolean hasPrimaryKey = StringUtils.isNotEmpty(primaryKeyName);
			int count = 0;
			
			fillValInMap(commandmap);
			fillCommonFieldVal(commandmap, object);
			
			//待设置的条件
			Set<String> condSet = new HashSet<String>();
			if(daoClass.equals(CertiAttrRela.class)) {
				condSet.add("infoId");
				condSet.add("attrKey");
			} else if(daoClass.equals(VoluPriceInfo.class)) {
				condSet.add("entRepoId");
				condSet.add("lineId");
			}
			
			Object criteria = createCriteria.invoke(example);
			for (smParamNode node : list) {
				key = node.getKey();
				value = node.getValue();
				SetValue(object, key, value);

				if (hasPrimaryKey && primaryKeyName.equals(key)) {
					primaryKeySetMethod.invoke(criteria, Long.valueOf(value));
				}
				
				if(daoClass.equals(CertiAttrRela.class) && condSet.contains(key)) {
					setFieldExample(criteria, key, value);
				}
				
				if(daoClass.equals(VoluPriceInfo.class) && condSet.contains(key)) {
					setFieldExample(criteria, key, value);
				}
				
			}
			
			if(hasPrimaryKey){
				count = countByExample(example);
			}
			Object mapper = getMapper(mapperClass);
			if (count > 0) {
				Object countObject = updateByExampleSelective.invoke(mapper, object, example);
				if (Integer.parseInt(countObject.toString()) > 0) {
					ret = InterStatusCode.SUCCESS;
				}
			} else {
				Object countObject = insertSelective.invoke(mapper, object);
				if (Integer.parseInt(countObject.toString()) > 0) {
					ret = InterStatusCode.SUCCESS;
				}
			}
			
			return ret;
		}
		
		
		private void setFieldExample(Object criteria, String key, String value) throws Exception {
			
			String attrMethodSet = "and" + key.substring(0,1).toUpperCase() + key.substring(1) + "EqualTo";
			Class fieldType = daoClass.getDeclaredField(key).getType();
			Method andFieldEqualTo = criteriaclasstype.getDeclaredMethod(attrMethodSet, fieldType);
			
			if(Long.class.equals(fieldType)) {
				andFieldEqualTo.invoke(criteria, Long.valueOf(value));
			} else if(Integer.class.equals(fieldType)) {
				andFieldEqualTo.invoke(criteria, Integer.valueOf(value));
			} else {
				andFieldEqualTo.invoke(criteria, value);
			}
		}
		
		private Object selectByExampleForPage(Object example , int rowsnum){
			PageList<Object> list = null;
			if(example!=null && selectByExampleForPage!=null&&mapperClass!=null){
				Object mapper = getMapper(mapperClass);
				if(mapper!=null){
					try {
						
						int pageNumber = 0; 
						if(rowsnum%PAGE_LIMIR == 0 ){
							pageNumber = rowsnum/PAGE_LIMIR;
						}else{
							pageNumber = rowsnum/PAGE_LIMIR + 1;
						};
						PageBounds pageBounds = new PageBounds();
						pageBounds.setLimit(PAGE_LIMIR);
						//pageBounds.setPage(pageNumber);
						pageBounds.setContainsTotalCount(true);
						
						list = (PageList<Object>) selectByExampleForPage.invoke(mapper, example,pageBounds);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						log.debug(e);
						list=null;
						msg="[%s]产生了类型[%s]的异常";
						msg=String.format(msg, key,e.getClass().getSimpleName());
					}
				}
			}
			
			
			return list ;
		}
		
		public Object select(Object example,PageParamInfo pageInfo){
			Object resultObject = null ;
			if(pageInfo==null || Strings.isNullOrEmpty(pageInfo.getPage())){
				resultObject = select(example);
			}else{
				msg="分页查询  总数[%s],页数是[%s],查找第[%s]页";
				msg=String.format(msg, pageInfo.getTotalcount(),pageInfo.getTotalpages(),pageInfo.getPage());
				resultObject = selectByExampleForPagebyPage(example,Integer.parseInt(pageInfo.getPage()));
			}
			return resultObject ;
		}
		
		private Object select(Object example){
			Object resultObject = null ;
			int count = countByExample(example);
			if(count == 0 ){
				msg="查询结果为0条";
			}
			if(count > PAGE_LIMIR){
				resultObject =  selectByExampleForPage(example,count);
			}else{
				resultObject =  selectByExample(example);
			}
			
			return resultObject ;
		}
		
		private int countByExample(Object example){
			int resultObject = -1 ;
			if(example!=null && selectByExample!=null&&mapperClass!=null){
				Object mapper = getMapper(mapperClass);
				if(mapper!=null){
					try {
						Object obj = countByExample.invoke(mapper, example);
						resultObject = Integer.parseInt(obj.toString());
					} catch (Exception e) {
						log.debug(e);
						resultObject=-1;
						msg="[%s]产生了类型[%s]的异常";
						msg=String.format(msg, key,e.getClass().getSimpleName());
					}
				}
				 
			}
			
			return  resultObject ;
		}
		
		public  Object selectByExample(Object example){
			Object resultObject = null ;
			if(selectByExample!=null&&mapperClass!=null){
				Object mapper = getMapper(mapperClass);
				if(mapper!=null){
					try {
						resultObject = selectByExample.invoke(mapper, example);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						log.debug(e);
						resultObject=null;
						msg="[%s]产生了类型[%s]的异常";
						msg=String.format(msg, key,e.getClass().getSimpleName());
					}
				}
				 
			}
			
			return resultObject ;
		}
		
		
		public Object GetValue(Object source , String propname){
			Object resultObject = null;
			String getfuncString= "get" + propname.substring(0, 1).toUpperCase() + propname.substring(1);
			Method mm = daomethodMap.get(getfuncString);

			if (mm != null) {
				try {
					resultObject = mm.invoke(source);
					
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					log.debug(e);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					log.debug(e);
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					log.debug(e);
				}
			}
			
			return resultObject;
		}
		
		
		public void SetValue(Object source, String propname, String paramvalue) {
			
			String setfuncString = "set"
					+ propname.substring(0, 1).toUpperCase()
					+ propname.substring(1);
			Method mm = daomethodMap.get(setfuncString);

			if (mm != null) {
				try {
					Class<?>[] paramtypes = mm.getParameterTypes();
					Class<?> type = paramtypes[0];
					if(!Strings.isNullOrEmpty(paramvalue)){
						Object curObject = StringUtil.Convter(type,paramvalue, date_format);
						mm.invoke(source, curObject);
					}
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					log.debug(e);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					log.debug(e);
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					log.debug(e);
				}
			}
		}
		
		public  Object newExample(SelectParamRoot root){
			Object example = null;
			try {
				if(!isAccess){
					return example;
				}
				example = classtype.newInstance();
				Object criteria = createCriteria.invoke(example);
				List<SelectWhereParam> wheres = root.getWheres();
				for(SelectWhereParam param:wheres){
					String funcname = param.getFuncName();
					Method funcMethod= methodMap.get(funcname);
					if(funcMethod == null){
						example=null;
						msg="找不到函数名[%s]";
						String.format(msg, key,funcname);
						isAccess = false;
						return null;
					}else{
						 Class<?>[] paramtypes=funcMethod.getParameterTypes();
						 List<Object> paramlist=Lists.newArrayList();
						 List<String> configlist=param.getParamList();
						 for(int i = 0 ; i < paramtypes.length ; i++ )
						 {
							
							 Class<?> type = paramtypes[i];
							 String paramvalue = configlist.get(i);
							 Object curObject = StringUtil.Convter(type, paramvalue, date_format);
							 
							 paramlist.add(curObject);
						 }
						 
						 if(paramtypes.length > 0){
							 funcMethod.invoke(criteria, paramlist.toArray());
						 }else{
							 funcMethod.invoke(criteria);
						 }
						 
					}
				}
				
			} catch (Exception e) {
				log.debug(e);
				example=null;
				msg="[%s]产生了类型[%s]的异常";
				msg=String.format(msg, key,e.getClass().getSimpleName());
				
			}
			return example;
		}
		private boolean isAccess = false;
		private String key;
		private Class<?> classtype;
		private Class<?> criteriaclasstype;
		private Class<?> mapperClass;
		private Class<?> daoClass;
		private Method createCriteria;
		private Method selectByExample;
		private Method selectByExampleForPage;
		private Method countByExample;
		private Method insertSelective;
		private Method updateByExampleSelective;
		private Method selectByExampleWithBLOBs;
		private String primaryKeyName;
		private Method primaryKeySetMethod;
		private Map<String, Method> methodMap=Maps.newHashMap();
		private Map<String, Method> mappermethodMap=Maps.newHashMap();
		private Map<String, Method> daomethodMap=Maps.newHashMap();
		
		
		public String GetExampleFullname(){
			return key + "Example";
		}
		
		public String GetMapperFullname(){
			return key + "Mapper";
		}
		
		public String getKey() {
			return key;
		}
	
		public boolean isAccess() {
			return isAccess;
		}
		
		public String getMsg() {
			return msg;
		}
		
		public Method getSelectByExampleForPage() {
			return selectByExampleForPage;
		}

		
		public Method getCountByExample() {
			return countByExample;
		}

		
		private String msg;
	}
	
	public static <E> E getMapper(Class<E> mapperClass) {
		return SpringContextUtil.getBean(mapperClass);
	}
	
	
	private List<BusiConfigRole> submapperlist = Lists.newArrayList();
	
	private Map<String, BusiConfigRole> configBusiConfigRoleMap = Maps.newHashMap();
	
	private void initConfigRole(){
		
		for(InterSwapPlatformConfigWithBLOBs config : configlist){
			BusiConfigRole role = new BusiConfigRole();
			role.setId("0");
			role.setParentId("-1");
			role.setParentRole(null);
			role.setLevelId("1");
			role.setServiceId(config.getServiceId());
			role.setSystemId(config.getSystemId());
			role.setReqBody(config.getReqBody());
			role.setRespBody(config.getRespBody());
			role.setKey(role.getSystemId() + role.getServiceId() + "_" + role.getId());
			SetSubConfig(role,role.getLevelId());
			submapperlist.add(role);
			configBusiConfigRoleMap.put(role.getKey(), role);
	    }
		
		
	}
	
	private void SetSubConfig(BusiConfigRole pareconfig,String level){
		String key = pareconfig.getKey();
		int nextlevle = Integer.parseInt(level) + 1;
		for(InterSpcAttr config : attrlist){
			String attrkey =config.getSystemId() + config.getServiceId() + "_" + config.getParentId();
			if(key.equals(attrkey)){
				BusiConfigRole node = new BusiConfigRole();
				node.setId(config.getId());
				node.setParentId(pareconfig.getId());
				node.setParentRole(pareconfig);
				node.setLevelId(level);
				node.setServiceId(config.getServiceId());
				node.setSystemId(config.getSystemId());
				node.setReqBody(config.getReqBody());
				node.setKey(config.getSystemId() +  config.getServiceId() + "_" + config.getId());
				node.setIstablename(config.getExtension());
				SetSubConfig(node,Integer.toString(nextlevle));
				pareconfig.getSubmapperlist().add(node);
				configBusiConfigRoleMap.put(node.getKey(), node);
			}
	    }
	}
	
	
	public String getMap_init() {
		return map_init;
	}

	private class BusiConfigRole implements Comparable<BusiConfigRole> {
		
		private BusiConfigRole parentRole;
		
		
		private String reqBody;	 
		public String getReqBody() {
			return reqBody;
		}
		public void setReqBody(String reqBody) {
			this.reqBody = reqBody;
		}
		public String getRespBody() {
			return respBody;
		}
		public void setRespBody(String respBody) {
			this.respBody = respBody;
		}
		public String getServiceId() {
			return serviceId;
		}
		public void setServiceId(String serviceId) {
			this.serviceId = serviceId;
		}
		public String getSystemId() {
			return systemId;
		}
		public void setSystemId(String systemId) {
			this.systemId = systemId;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getParentId() {
			return parentId;
		}
		public void setParentId(String parentId) {
			this.parentId = parentId;
		}
		public String getLevelId() {
			return levelId;
		}
		public void setLevelId(String levelId) {
			this.levelId = levelId;
		}
		private String respBody;
		private String serviceId; 
		private String systemId; 
		private String id;
		private String parentId;
	    private String levelId;
	    private String key;
	    private String istablename;
	    
		public String getIstablename() {
			return istablename;
		}
		public void setIstablename(String istablename) {
			this.istablename = istablename;
		}
		public BusiConfigRole getParentRole() {
			return parentRole;
		}
		public void setParentRole(BusiConfigRole parentRole) {
			this.parentRole = parentRole;
		}
		public List<BusiConfigRole> getSubmapperlist() {
			return submapperlist;
		}
		
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		private List<BusiConfigRole> submapperlist = Lists.newArrayList();
		@Override
		public int compareTo(BusiConfigRole o) {
			// TODO Auto-generated method stub
			int onenum =Integer.parseInt(this.getId());
			int twonum = Integer.parseInt(o.getId());
			return onenum - twonum;
		}
		
	}
	
	private DBEventSource  dbSource = null;
	
	private interface DBSubject {
		public void registerObserver(DBEventListener observer);
		public void removeObserver(DBEventListener observer);
	    public void notifyAllObservers(DBEvent event);
	}
	
	
	private class DBEvent extends EventObject{

		public DBEvent(Object source) {
			super(source);
			// TODO Auto-generated constructor stub
		}

		public DBOperType getOperType() {
			return operType;
		}


		public void setOperType(DBOperType operType) {
			this.operType = operType;
		}

		public StringBuffer getRespBuffer() {
			return respBuffer;
		}

		public void setRespBuffer(StringBuffer respBuffer) {
			this.respBuffer = respBuffer;
		}

		public InterStatusCode getCode() {
			return code;
		}

		public void setCode(InterStatusCode code) {
			this.code = code;
		}

		/**
		 * 
		 */
		private static final long serialVersionUID = 2567690031948686895L;
		
		
		private DBOperType operType;
		
		private StringBuffer respBuffer;
		
		private InterStatusCode code ;
		
	}
	
	
	private interface DBEventListener extends EventListener{
		public void processEvent(DBSubject subject,DBEvent event);
	}
	
	private class DBEventSource implements DBSubject {
		private List<DBEventListener> listeners = Lists.newArrayList();

		@Override
		public void registerObserver(DBEventListener observer) {
			if(observer!=null){
				listeners.add(observer);
			}
			
		}

		@Override
		public void removeObserver(DBEventListener observer) {
			if(observer!=null){
				listeners.remove(observer);
			}
			
		}

		@Override
		public void notifyAllObservers(DBEvent event) {
			for (DBEventListener listener : listeners) {
				listener.processEvent(this,event);
			}
		}

		
	}
	
	
	public class DBDMLEventListener implements DBEventListener{

		@Override
		public void processEvent(DBSubject subject, DBEvent event) {
			if(event!=null){
				String reqcontext = event.getSource().toString();
				RoadWayServiceRoot root = (RoadWayServiceRoot) XmlOper.xml2Bean(RoadWayServiceRoot.class, reqcontext);
				InterStatusCode code = InterStatusCode.NUKONW_ERROR;
				
				if(root!=null){
					
					List<smParamNode> list = root.getSmParamNode().getSmParamNode();
					for(smParamNode sNode : list){
						if(sNode.getSmParamNode().size() >0){
							String classname = sNode.getId();
							String oper = sNode.getValue();
							DBOperType operType = DBOperType.getOperType(oper);
							if(!Strings.isNullOrEmpty(classname)&&oper!=null){
								log.debug(String.format("processEvent Process data : [%s],[%s]", sNode.getId(),oper));
								DBMybatisObject dMybatisObject = getDBMybatisObject(classname);
								if(dMybatisObject!=null&&dMybatisObject.iSAccess){
									StringBuffer resultcontext = new StringBuffer();
									code=dMybatisObject.dboper(operType, sNode, resultcontext);
									
									event.setCode(code);
									event.setRespBuffer(resultcontext);
									
								}else {
									code=InterStatusCode.DB_SIGN_ERROR;
									log.debug(code.getDescription());
									event.setCode(code);
									
									break;
								}
							}
						}
					}
					
					
				}else{
					code=InterStatusCode.PARSE_MODIFY_REQ_ERROR;
					
					log.debug(code.getDescription());
				}
				
				
			}
			
		}
		
		private Map<String, DBMybatisObject> map = Maps.newHashMap();
		
		private Object lockerObject = new Object();
		private DBMybatisObject getDBMybatisObject(String key){
			synchronized (lockerObject) {
				DBMybatisObject dMybatisObject = null;
				if(map.containsKey(key)){
					dMybatisObject = map.get(key);
				}else {
					dMybatisObject = new DBMybatisObject(key);
					map.put(key, dMybatisObject);
				}
				
				return dMybatisObject ; 
			}
		}
		
	}
	
	private class DBMybatisObject{
		
		public DBMybatisObject(String classname){
		
			if(classname.endsWith("WithBLOBs")){
				String [] splitarray = classname.split("WithBLOBs");
				this.classname=splitarray[0] ;
			}else{
				this.classname=classname ;
			}
			
			if(classname.toLowerCase().startsWith("inter")){
				this.domain = DB_INTER_DOMAIN;
				this.dao=DB_INTER_DAO;
				
			}else {
				
				this.domain = DB_DOMAIN;
				this.dao=DB_DAO;
			}
			
			
			
			init();
		}
		
		private void init(){
			try {
				exampleclass = Class.forName(getFullExampleName());
				mapperClass = Class.forName(getFullMapperName());
				daoClass = Class.forName(getFullDomainName());
				
				try{
					daowithclobClass = Class.forName(getFullDomainWithClobName());
				}catch(Exception e){
					
				}
				Object  example = exampleclass.newInstance();
			    createCriteria = exampleclass.getMethod("createCriteria");
			    Object Criteria = createCriteria.invoke(example);
				criteriaclasstype = Criteria.getClass();
				
				dbClassProp = new DBClassProp(daoClass,exampleclass,mapperClass,criteriaclasstype,daowithclobClass);
				
				iSAccess = true;
				error_msg ="success";
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				iSAccess = false;
				error_msg =e.getMessage();
			}
			
		}
		
		private int execFunc(Object criteria,String field,String fieldvalue){
			int ret = -1 ;
			String methodname = TableValueOper.GetValueName(field);
			methodname = String.format(DB_EXAMPLE_OPER_TYPE.andEqualTo.getCode(), methodname);
			
			Method criteriaandEqualTo = this.dbClassProp.criteria.getMethodProps().GetMethod(methodname);
			
			if(criteriaandEqualTo!=null){
				
				 Class<?>[] paramtypes=criteriaandEqualTo.getParameterTypes();
				 Class<?> type = paramtypes[0];
				 Object curObject = StringUtil.Convter(type, fieldvalue, date_format);
				 
				 try {
					criteriaandEqualTo.invoke(criteria, curObject);
					ret = 0 ;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			
			return ret;
			
		}
		
		private Object newExample(smParamNode resurce){
			Object example = null;
			try {
				if(!isiSAccess()){
					return example;
				}
				
				example = exampleclass.newInstance();
				Object criteria = createCriteria.invoke(example);
				
				boolean sign = false;
				
				if(dbClassProp.getUnionPrimaryKeyAttrList().size() > 0){
					for (String keyattr : dbClassProp.getUnionPrimaryKeyAttrList()) {
						boolean findsign = false;
						for (smParamNode sParamNode : resurce.getSmParamNode()) {
							if(keyattr.equals(sParamNode.getKey())){
								findsign = true;
								int ret = execFunc(criteria,sParamNode.getKey(),sParamNode.getValue());
								if(ret < 0){
									return null;
								}
							}
						}
						
						if(!findsign){
							sign = true;
							break;
						}
					}
				}else {
					sign = true;
				}
				
				if(sign){
					for (smParamNode sParamNode : resurce.getSmParamNode()) {
						int ret = execFunc(criteria,sParamNode.getKey(),sParamNode.getValue());
						if(ret < 0){
							log.debug(String.format("此字段没有相关的判断:[%s]", sParamNode.getKey()));;
						}
					}
				}
			} catch (Exception e) {
				log.debug(e);
				example=null;
			}
			
			return example;
		}
		
		
		private void SetValue(Object source, String propname, String paramvalue) {
			String setfuncString = "set"
					+ TableValueOper.GetValueName(propname);
			String classname  = source.getClass().getSimpleName() ;
			Method mm = dbClassProp.domain.methodProps.GetMethod(setfuncString);
			
			if(classname.endsWith("WithBLOBs") && mm == null){
				mm = dbClassProp.domainWithBlob.methodProps.GetMethod(setfuncString);
			}
			
			if (mm != null) {
				try {
					Class<?>[] paramtypes = mm.getParameterTypes();
					Class<?> type = paramtypes[0];
					Object curObject = StringUtil.Convter(type,paramvalue, date_format);
				    mm.invoke(source, curObject);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					log.debug(e.getMessage());
				} 
			}
		}
		
		private Object newDomain(smParamNode resurce){
			Object domain =null;
			try {
				boolean isBlobs = false;
				if(resurce.getId().endsWith("WithBLOBs")){
					isBlobs = true;
				}
				if(isBlobs && daowithclobClass!=null){
					domain = daowithclobClass.newInstance();
				}else{
					domain = daoClass.newInstance();
				}
			    
			    for (smParamNode sNode : resurce.getSmParamNode()) {
			    	SetValue(domain,sNode.getKey(),sNode.getValue());
				}
			    
			    // 判断是否有序列
			    for(Map.Entry<String, SelectValBySequence> entry:dbClassProp.getSeqMap().entrySet()){   
			    		
			    	String fieldname = entry.getKey() ; 
			    	SelectValBySequence sequence = entry.getValue();
			    	
			    	Map<String, String> sequenceMap = new HashMap<String, String>();
					sequenceMap.put("sequenceName", sequence.SequenceName());
			    	long seqnum =  systemMapper.generateId(sequenceMap);
			    	
			    	SetValue(domain,fieldname,String.valueOf(seqnum));
				}
			    
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.debug(e.getMessage());
				domain =null;
			}
			
			return domain;
		}
		
		private int countByExample(Object mapper,Object example){
			int count = 0 ;
			Method countMethod= dbClassProp.mapper.getMethodProps().GetMethod(DB_MAPPER_OPER_TYPE.countByExample.getCode());
			if(countMethod!=null){
				try {
					Object object = countMethod.invoke(mapper, example);
					count = Integer.parseInt(object.toString());
				} catch (Exception e) {
					count = -1;
				}
			}
			
			return count ;
		}
		
		private Object invoke(Method oper,Object mapper,Object... args){
			Object result = null;
			if(oper!=null){
				try {
					result = oper.invoke(mapper, args);
				} catch (Exception e) {
					log.debug(e.getMessage());
					result = null;
				}
			}
			
			return result ;
		}
		
		public <E> E getMapper(Class<E> mapperClass) {
			return SpringContextUtil.getBean(mapperClass);
		}
		
		public InterStatusCode dboper(DBOperType oper,smParamNode resurce,StringBuffer resultcontext){
			InterStatusCode code = InterStatusCode.SUCCESS ;
			
			if(resurce!=null && resurce.getSmParamNode().size() >0){
	
				Object example = newExample(resurce);
				Object domain = newDomain(resurce);
				Object mapper = getMapper(mapperClass);
				Method dboper = null;
				if( mapper == null ||  domain == null || example==null){
					return InterStatusCode.DB_NULL_ERROR;
				}
				int count = -1;
				Object result = null;
				switch (oper) {
				case DB_DONE :
					code = InterStatusCode.DB_NO_MATCH_ERROR;
					code.setTempString(String.format(code.getDescription(), mapper.getClass().getSimpleName()));
					log.debug(code.getTempString());
					break;
				case DB_INSERT :
					dboper = dbClassProp.mapper.getMethodProps().GetMethod(DB_MAPPER_OPER_TYPE.insertSelective.getCode());
					if(dboper !=null){
						count = countByExample(mapper,example);
						if(count == 0){
							result = invoke(dboper,mapper,domain);
						}else {
							code = InterStatusCode.DB_INSERT_ERROR ;
							code.setTempString(String.format(code.getDescription(), mapper.getClass().getSimpleName()));
						}
					}
					break;
				case DB_UPDATE :
					 if(dbClassProp.getUnionPrimaryKeyAttrList().size() == 0){
						 code = InterStatusCode.DB_KEY_ERROR ;
					 }else {
						 dboper = dbClassProp.mapper.getMethodProps().GetMethod(DB_MAPPER_OPER_TYPE.updateByExampleSelective.getCode());
						 if(dboper!=null){
							 	count = countByExample(mapper,example);
							 	if(count > 0){
									result = invoke(dboper,mapper,domain,example);
								}else {
									code = InterStatusCode.DB_UPDATE_ERROR ;
									code.setTempString(String.format(code.getDescription(), mapper.getClass().getSimpleName()));
								}
						 }
					}
					 
					 
					break;
				case DB_DELETE :
					if(dbClassProp.getUnionPrimaryKeyAttrList().size() == 0){
						 code = InterStatusCode.DB_KEY_ERROR ;
						 code.setTempString(String.format(code.getDescription(), mapper.getClass().getSimpleName()));
					 }else {
						 dboper = dbClassProp.mapper.getMethodProps().GetMethod(DB_MAPPER_OPER_TYPE.deleteByExample.getCode());
						 if(dboper!=null){
							 count = countByExample(mapper,example);
							 if(count > 0){
									result = invoke(dboper,mapper,example);
							 }else {
									code = InterStatusCode.DB_DELETE_ERROR ;
									code.setTempString(String.format(code.getDescription(), mapper.getClass().getSimpleName()));
							 }
						 }
					}
					 
					
					 
					 
					break;
				case DB_SELECT :
					code = InterStatusCode.DB_NO_MATCH_ERROR;
					break;
				case DB_INSERT_LOG :
					dboper = dbClassProp.mapper.getMethodProps().GetMethod(DB_MAPPER_OPER_TYPE.countByExampleByname.getCode());
					String curdate = getCurDate();
					if(dboper!=null){
					    
						boolean sign = false;
						try {
							result = invoke(dboper,mapper,curdate);
							if(result ==null ){
								sign = false;
							}else{
								sign = true;
							}	
						} catch (Exception e) {
							sign = false;
						}
						
						boolean createtable= true;
						if(!sign){
							
							dboper = dbClassProp.mapper.getMethodProps().GetMethod(DB_MAPPER_OPER_TYPE.createTableByname.getCode());
							if(dboper!=null){
								try {
									result = invoke(dboper,mapper,curdate);
									createtable = true;
								} catch (Exception e) {
									code = InterStatusCode.LOG_CONTEXT_CREATETABLE_ERROR;
									createtable = false;
								}
							}else {
								code = InterStatusCode.LOG_CONTEXT_CREATETABLEMETHOD_ERROR;
								createtable = false;
							}
						}
						
						if(createtable){
							dboper = dbClassProp.mapper.getMethodProps().GetMethod(DB_MAPPER_OPER_TYPE.insertSelectiveByname.getCode());
							if(dboper!=null){
								result = invoke(dboper,mapper,curdate,domain);
								if(result == null){
									code = InterStatusCode.LOG_CONTEXT_INSERTMETHOD_ERROR;  
								}
							}else {
								code = InterStatusCode.LOG_CONTEXT_INSERTMETHOD_ERROR;  
							}
						}
					}else {
						code = InterStatusCode.LOG_CONTEXT_METHOD_ERROR;
					}
					
					break;
				default:
					break;
				}
				
				if(code == InterStatusCode.SUCCESS){
					int retcount = Integer.parseInt(result.toString());
					if(retcount <= 0){
						code = InterStatusCode.DB_MOD_ERROR;
						code.setTempString(String.format(code.getDescription(), mapper.getClass().getSimpleName()));
						log.debug(code.getTempString());
					}else {
						resultcontext.append(retcount);
					}
				}else {
					if(Strings.isNullOrEmpty(code.getTempString())){
						log.debug(code.getDescription());
					}else {
						log.debug(code.getTempString());
					}
					
				}
			}else {
				code = InterStatusCode.PARSE_RESULT_ERROR ;
				code.setTempString(String.format(code.getDescription(), getMapperName()));
			}
			
			return code ;
		}
		
		private String getCurDate(){
			String curtime = "";
			try {
				Date curDate = DateUtil.getCurrentDate(log_table_format);
				curtime = DateUtil.format(curDate, log_table_format);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return curtime;
		}
		
		private String error_msg;
		private boolean iSAccess;
		
		private String domain;
		private String dao;
		private String classname;
	
		
		private Class<?> exampleclass;
		private Class<?> mapperClass ; 
		private Class<?> daoClass ;
		private Class<?> daowithclobClass;
		private Class<?> criteriaclasstype;
		
		private DBClassProp dbClassProp;
		
		private Method createCriteria;
		
		public String getMapperName(){
			return classname + "Mapper" ;
		}
		
		public String getFullMapperName(){
			return this.dao  + getMapperName() ;
		}
		
		public String getDomainName(){
			return classname  ;
		}
		
		public String getFullDomainName(){
			return this.domain + getDomainName() ;
		}
		
		public String getDomainWithClobName(){
			return classname + "WithBLOBs" ;
		}
		
		public String getFullDomainWithClobName(){
			return this.domain + getDomainWithClobName() ;
		}
		
		public String getExampleName(){
			return classname + "Example" ;
		}
		
		public String getFullExampleName(){
			return this.domain + getExampleName() ;
		}
		
		public String GetLogStatus(DBMybatisObject object,boolean isFullname){
			if(object!=null){
				if(isFullname){
					return String.format("Domain:[%s],Mapper:[%s],Name:[%s]", object.getFullDomainName(),object.getFullMapperName(),object.getFullExampleName());
				}else {
					return String.format("Domain:[%s],Mapper:[%s],Name:[%s]", object.getDomainName(),object.getMapperName(),object.getExampleName());
				}
			}else{
				return "";
			}
		}
		
		public String getError_msg() {
			return error_msg;
		}
		
		
		
		
		private class DBClassProp{
			protected ClassProp mapper=null;
			protected ClassProp example=null;
			protected ClassProp domain=null;
			protected ClassProp domainWithBlob=null;
			protected ClassProp criteria=null;
			
			public  DBClassProp(Class<?> domain , Class<?> example, Class<?> mapper, Class<?> criteria,Class<?> domainWithBlob) {
				this.domain =  new ClassProp(domain);
				this.example = new ClassProp(example);
				this.mapper = new  ClassProp(mapper);
				this.criteria = new  ClassProp(criteria);
				
				List<Field> fields = Lists.newArrayList();
				
				fields.addAll(this.domain.getFieldProps().getFields());
				
				
				if(domainWithBlob!=null){
					this.domainWithBlob = new ClassProp(domainWithBlob);
					fields.addAll(this.domainWithBlob.getFieldProps().getFields());
				}
								
				for (Field field : fields) {
					
					domainMap.put(field.getName(), field);
					
					UnionPrimaryKeyAttr meta = field.getAnnotation(UnionPrimaryKeyAttr.class);
					if(meta!=null){
						unionPrimaryKeyAttrList.add(field.getName());
						unionPrimaryKeyAttrMap.put(field.getName(), field.getType());
					}
					
					boolean hasAnnotation = field.isAnnotationPresent(SelectValBySequence.class);
					if(hasAnnotation) {
						SelectValBySequence annotation = field.getAnnotation(SelectValBySequence.class);
						seqMap.put(field.getName(), annotation);
					}
				}
			}
			
			public List<String> getUnionPrimaryKeyAttrList() {
				return unionPrimaryKeyAttrList;
			}

			private Map<String, SelectValBySequence> seqMap = Maps.newHashMap();
			
			public Map<String, SelectValBySequence> getSeqMap() {
				return seqMap;
			}
			
			public Field GetDomain(String key){
				return domainMap.get(key);
			}
			
			private List<String> unionPrimaryKeyAttrList = Lists.newArrayList();
			
			private Map<String,Field> domainMap = Maps.newHashMap();
			
			private Map<String, Class<?>> unionPrimaryKeyAttrMap = Maps.newHashMap();

			public Map<String, Class<?>> getUnionPrimaryKeyAttrMap() {
				return unionPrimaryKeyAttrMap;
			}
		}
		private class ClassProp{
			public ClassProp(Class<?> classtype){
				this.daoClass = classtype;
				methodProps = new MethodProps(classtype);
				fieldProps = new FieldProps(classtype);
			}
			
			public MethodProps getMethodProps() {
				return methodProps;
			}
			
			public FieldProps getFieldProps() {
				return fieldProps;
			}

			
			protected MethodProps methodProps =null;
			protected FieldProps  fieldProps = null;
			protected Class<?> daoClass;
			
		}
		
		
		private class MethodProps{
			public MethodProps(Class<?> classtype){
				this.daoClass = classtype;
				
				Method [] methods = daoClass.getDeclaredMethods();
				
				for (Method method : methods) {
					AddMethod(method);
				}
				
				Class<?> superClass  = daoClass.getSuperclass() ; 
				
				if(superClass!=null){
					Method [] supermethods = superClass.getDeclaredMethods();
					
					for (Method method : supermethods) {
						AddMethod(method);
					}
				}
			}
			
			protected List<Method> methods = Lists.newArrayList();
			protected Map<String, Method> map = Maps.newHashMap();
			
			protected Class<?> daoClass;
			
			private void AddMethod(Method method){
				methods.add(method);
				map.put(method.getName(), method);
			}
			
			public Method GetMethod(String methodname){
				return map.get(methodname);
			}
		}
		
		private class FieldProps{
			public FieldProps(Class<?> classtype){
				this.daoClass = classtype;
				
				Field [] fields = daoClass.getDeclaredFields();
				
				for (Field field : fields) {
					AddField(field);
				}
				
				
				Class<?> superClass  = daoClass.getSuperclass() ; 
				
				if(superClass!=null){
					Field [] supermethods = superClass.getDeclaredFields();
					
					for (Field method : supermethods) {
						AddField(method);
					}
				}
				
			}
			protected List<Field> fields = Lists.newArrayList();
			protected Map<String, Field> map = Maps.newHashMap();
			
			protected Class<?> daoClass;
			
			private void AddField(Field field){
				fields.add(field);
				map.put(field.getName(), field);
			}
			
			public Field GetField(String fieldname){
				return map.get(fieldname);
			}
			
			public List<Field> getFields(){
				return fields;
			}
		}

		public boolean isiSAccess() {
			return iSAccess;
		}

		
	}
	
	

	
}
