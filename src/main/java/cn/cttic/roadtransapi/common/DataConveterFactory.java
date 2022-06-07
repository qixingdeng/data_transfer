package cn.cttic.roadtransapi.common;


public class DataConveterFactory {
	 public static IDataConverter getConveterInstance(String type){
		 IDataConverter c=null;
		 
	      	if(type.equals("DatetypeConveterImpl")){
	      		c = new DatetypeConveterImpl();
	      	}
	        return c;
	    }
}
