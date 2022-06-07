package cn.cttic.roadtransapi.mgr;

import java.util.Map;

import cn.cttic.roadtransapi.common.DataConveterFactory;
import cn.cttic.roadtransapi.common.DatetypeConveterImpl;
import cn.cttic.roadtransapi.common.IDataConverter;

import com.google.common.collect.Maps;

public class ConvterDataMgr  {
	
	private ConvterDataMgr(){
		
		ProcessBusi();
	}
	
	private static ConvterDataMgr uniqueInstance = null;
	
	public static ConvterDataMgr getInstance() {
	    if (uniqueInstance == null) {
	           uniqueInstance = new ConvterDataMgr();
	       }
	       return uniqueInstance;   
	}
	  
	
	private void ProcessBusi(){
		AddConvter(DatetypeConveterImpl.class.getSimpleName());
	}
	
	private Map<String, IDataConverter> DataConverterMap = Maps.newHashMap();
	
	public Object Conveter(String key,Object source){
		IDataConverter conveterConverter = DataConverterMap.get(key);
		Object object = null;
		if(conveterConverter!=null){
			object = conveterConverter.Converter(source);
		}
		
		return object;
	}
	
	private void AddConvter(String key){
		IDataConverter conveterConverter = DataConveterFactory.getConveterInstance(key);
		if(conveterConverter!=null){
			DataConverterMap.put(key, conveterConverter);
		}
	}
	
	
}
