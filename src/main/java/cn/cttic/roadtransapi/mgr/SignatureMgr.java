package cn.cttic.roadtransapi.mgr;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import cn.cttic.roadtransapi.code.InterLogProcCode;
import cn.cttic.roadtransapi.code.InterStatusCode;
import cn.cttic.roadtransapi.constants.RoadWayConstants;
import cn.cttic.roadtransapi.dao.InterSpcSignatureMapper;
import cn.cttic.roadtransapi.domain.InterSpcSignature;
import cn.cttic.roadtransapi.domain.InterSpcSignatureExample;
import cn.cttic.roadtransapi.generator.Keys;
import cn.cttic.roadtransapi.signature.Base64;
import cn.cttic.roadtransapi.signature.MD5Util;
import cn.cttic.roadtransapi.signature.Signaturer;
import cn.cttic.roadtransapi.ws.Transaction;
import cn.cttic.roadtransapi.ws.TransactionSignature;
import cn.cttic.sysframe.common.util.DateUtil;
import cn.cttic.sysframe.common.util.SpringContextUtil;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;



public class SignatureMgr  {
	
	private SignatureMgr(){
		//Init();
		init();
	}
	
	private static SignatureMgr uniqueInstance = null;
	
	public static SignatureMgr getInstance() {
	    if (uniqueInstance == null) {
	           uniqueInstance = new SignatureMgr();
	       }
	       return uniqueInstance;   
	}
	
	private static Logger log = Logger.getLogger(SignatureMgr.class);
	
	Map<String, InterSpcSignature> provinceCodemaps =Maps.newHashMap();
	Map<String, String> provincepublicmaps =Maps.newHashMap();
	private void init(){
		try{
			List<InterSpcSignature> infolist = DBMgr.getInstance().getInfolist();
	    		
	    	for(InterSpcSignature iBs : infolist){
	    		provinceCodemaps.put(iBs.getRegionCode(), iBs);
	    		provincepublicmaps.put(iBs.getRegionCode(), iBs.getPublicKey());
	    	}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
    
    	
	}
	
	private void Init(){
		
    	InterSpcSignatureMapper mapper = SpringContextUtil.getBean(InterSpcSignatureMapper.class);
    	
    	List<InterSpcSignature> infolist = mapper.selectByExample(null);
    	Map<String, InterSpcSignature> maps =Maps.newHashMap();
    	
    	for(InterSpcSignature iBs : infolist){
    		try {
				Map<String, Object> keyMap =Keys.initKey();
				String publicKey =  Keys.getPublicKey(keyMap);
    			System.out.println(publicKey);
    			String privateKey =  Keys.getPrivateKey(keyMap);
    			System.out.println(privateKey);
    			InterSpcSignature neWithBLOBs = new InterSpcSignature();
    			neWithBLOBs.setRegionCode(iBs.getRegionCode());
    			neWithBLOBs.setRegionCodeDesc(iBs.getRegionCodeDesc());
    			neWithBLOBs.setExtension(iBs.getExtension());
    			neWithBLOBs.setStatus("0");
    		
    			neWithBLOBs.setPrivateKey(privateKey);
    			neWithBLOBs.setPublicKey(publicKey);
    			InterSpcSignatureExample example = new InterSpcSignatureExample();
    			InterSpcSignatureExample.Criteria criteria = example.createCriteria();
    			criteria.andRegionCodeEqualTo(iBs.getRegionCode());
    			mapper.updateByExampleSelective(neWithBLOBs, example);
    			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
    	}
    	
    	
    	
	}

	public InterStatusCode ProcessBusi(Transaction request){
		InterStatusCode ret = InterStatusCode.NUKONW_ERROR;
		String logString ;
		String context = request.getTransactionBody();
		String provinceCode = request.getTransactionHeader().getTransactionSourceservice();
		TransactionSignature signature = request.getTransactionHeader().getTransactionSignature();
		String transactionDetail = signature.getTransactionDetail() ; 
		String transactionMd5= signature.getTransactionMd5();
		
		if(!Strings.isNullOrEmpty(context)){
			
			logString = "请求数据的数据摘要是:[%s],[%s]";
			logString = String.format(logString, context,provinceCode);
			log.debug(logString);
			
			if (signature == null
					|| (Strings.isNullOrEmpty(transactionDetail) && Strings
							.isNullOrEmpty(transactionMd5))) {
				ret = InterStatusCode.GET_SIGNATURE_INFO_ERROR;
				ret.setTempString(String.format(ret.getDescription(), request
						.getTransactionHeader().getTransactionSerialnum()));
				log.debug(ret.getTempString());
			} else {
				// System.setProperty("file.encoding", "UTF-8");
				String base64 = Base64.getBase64(context);
				try {
					log.info("============= context bytes: " + context.getBytes("utf-8"));
					log.info("============= base64:" + base64);
					log.info("============= base64 bytes:" + base64.getBytes());
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				String lineSeparator = System.getProperty("line.separator");
				Pattern p = Pattern.compile("\\s*|\t|\r|\n");
				Matcher m = p.matcher(base64);
				base64 = m.replaceAll("");
				log.info(base64);
				String md5 = MD5Util.strToMD5(base64);
				log.info(lineSeparator + "=====  file.encoding:"
						+ System.getProperty("file.encoding") + "  ====="
						+ lineSeparator + "=====  md5:" + md5 + "  =====");
				if (!Strings.isNullOrEmpty(transactionDetail)) {
					String publicKey = provincepublicmaps.get(provinceCode);
					if (Strings.isNullOrEmpty(publicKey)) {
						ret = InterStatusCode.GET_SIGNATURE_PRIVATE_ERROR;
						ret.setTempString(String.format(ret.getDescription(),
								provinceCode));
						log.debug(ret.getTempString());
					} else {
						boolean verify = Signaturer.verify(
								publicKey.getBytes(), md5,
								transactionDetail.getBytes());
						if (verify) {
							ret = InterStatusCode.SUCCESS;
						} else {
							ret = InterStatusCode.GET_SIGNATURE_TEST_ERROR;
							ret.setTempString(String.format(ret
									.getDescription(), request
									.getTransactionHeader()
									.getTransactionSerialnum()));
							log.debug(ret.getTempString());
						}

					}

				} else {
					if (md5.equals(transactionMd5)) {
						ret = InterStatusCode.SUCCESS;
					} else {
						ret = InterStatusCode.GET_SIGNATURE_TEST_ERROR;
						ret.setTempString(String.format(ret.getDescription(),
								request.getTransactionHeader()
										.getTransactionSerialnum()));
						log.debug(ret.getTempString());
					}
				}
			}
		}else{
			ret=InterStatusCode.GET_SIGNATURE_ERROR;
			ret.setTempString(String.format(ret.getDescription()));
			log.debug(ret.getTempString());
		}
		
		return ret;
	}

	
	public InterStatusCode ProcessBusi(cn.cttic.roadtransapi.ws_roadway.Transaction request){
		InterStatusCode ret = InterStatusCode.NUKONW_ERROR;
		String logString ;
		String context = request.getTransactionBody();
		String provinceCode = request.getTransactionHeader().getTransactionSourceservice();
		cn.cttic.roadtransapi.ws_roadway.TransactionSignature signature = request.getTransactionHeader().getTransactionSignature();
		String transactionDetail = signature.getTransactionDetail() ; 
		String transactionMd5= signature.getTransactionMd5();
		String md5 = null ;
		if(!Strings.isNullOrEmpty(context)){
			
			logString = "请求数据的数据摘要是:[%s],[%s]";
			logString = String.format(logString, context,provinceCode);
			log.debug(logString);
			
			if (signature == null
					|| (Strings.isNullOrEmpty(transactionDetail) && Strings
							.isNullOrEmpty(transactionMd5))) {
				ret = InterStatusCode.GET_SIGNATURE_INFO_ERROR;
				ret.setTempString(String.format(ret.getDescription(), request
						.getTransactionHeader().getTransactionSerialnum()));
				log.debug(ret.getTempString());
			} else {
				// System.setProperty("file.encoding", "UTF-8");
				String base64 = Base64.getBase64(context);
				try {
					log.info("============= context bytes: " + context.getBytes("utf-8"));
					log.info("============= base64:" + base64);
					log.info("============= base64 bytes:" + base64.getBytes());
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				String lineSeparator = System.getProperty("line.separator");
				Pattern p = Pattern.compile("\\s*|\t|\r|\n");
				Matcher m = p.matcher(base64);
				base64 = m.replaceAll("");
				log.info(base64);
			    md5 = MD5Util.strToMD5(base64);
				log.info(lineSeparator + "=====  file.encoding:"
						+ System.getProperty("file.encoding") + "  ====="
						+ lineSeparator + "=====  md5:" + md5 + "  =====");
				if (!Strings.isNullOrEmpty(transactionDetail)) {
					String publicKey = provincepublicmaps.get(provinceCode);
					if (Strings.isNullOrEmpty(publicKey)) {
						ret = InterStatusCode.GET_SIGNATURE_PRIVATE_ERROR;
						ret.setTempString(String.format(ret.getDescription(),
								provinceCode));
						log.debug(ret.getTempString());
					} else {
						boolean verify = Signaturer.verify(
								publicKey.getBytes(), md5,
								transactionDetail.getBytes());
						if (verify) {
							ret = InterStatusCode.SUCCESS;
						} else {
							ret = InterStatusCode.GET_SIGNATURE_TEST_ERROR;
							ret.setTempString(String.format(ret
									.getDescription(), request
									.getTransactionHeader()
									.getTransactionSerialnum()));
							log.debug(ret.getTempString());
						}

					}

				} else {
					if (md5.equals(transactionMd5)) {
						ret = InterStatusCode.SUCCESS;
					} else {
						ret = InterStatusCode.GET_SIGNATURE_TEST_ERROR;
						ret.setTempString(String.format(ret.getDescription(),
								request.getTransactionHeader()
										.getTransactionSerialnum()));
						log.debug(ret.getTempString());
					}
				}
			}
		}else{
			ret=InterStatusCode.GET_SIGNATURE_ERROR;
			ret.setTempString(String.format(ret.getDescription()));
			log.debug(ret.getTempString());
		}
		
		if(LogMgr.getInstance().isSign()){
			Map<String, Object> sourecMap= Maps.newHashMap();
	        sourecMap.put(RoadWayConstants.CXF_STEP, InterLogProcCode.REQ_SIGNATURE_STEP); 
	        sourecMap.put(InterLogProcCode.REQ_SIGNATURE_STEP.getCode(), ret);
	        Date signDate = (Date) DateUtil.getServerDate();
	        sourecMap.put(RoadWayConstants.RECVIVE_SERIALIZE_DATE, signDate);
	        LogMgr.getInstance().BusiProc(this, sourecMap);
		}
		
		
		return ret;
	}

	
}
