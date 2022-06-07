package cn.cttic.roadtransapi.common;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cn.cttic.sysframe.common.util.DateUtil;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

public class StringUtil {
	public static Object Convter(Class<?> type,String paramvalue,String date_format){
		 
		 Object curObject =null;
		 
		 if(Strings.isNullOrEmpty(paramvalue)){
			 paramvalue = "";
		 }
		 
		 if(type.getSimpleName().equals("Long")){
			 curObject = Long.parseLong(paramvalue);
		 }else if (type.getSimpleName().equals("Integer")) {
			 curObject = Integer.parseInt(paramvalue);
		 }else if (type.getSimpleName().equals("BigDecimal")) {
			 BigDecimal temp  = new BigDecimal(paramvalue);
			 curObject =temp;
		 }else if (type.getSimpleName().equals("Short")) {
			 curObject = Short.parseShort(paramvalue);	
		 }else if (type.getSimpleName().equals("Double")) {
			 curObject = Double.parseDouble(paramvalue);
		 }else if (type.getSimpleName().equals("List")) {
			 String  [] vStrings = paramvalue.split(",");
			 List<String> list= Lists.newArrayList(vStrings);
			 curObject = list;
		 }else if (type.getSimpleName().equals("Date")) {	
			 if(Strings.isNullOrEmpty(date_format)){
				 curObject = StrToDate(paramvalue,DateUtil.PATTERN_YYYY_MM_DD_HH_MM);		 
			 }else {
				 curObject = StrToDate(paramvalue,date_format);
			}
			 
		 }else{
			 curObject = paramvalue;
		 }
		 
		 return curObject ;
	}
	
	public static String Convter(Object source,String date_format){
		String curObject =null;
		Class<?> type = source.getClass();
		if(type.getSimpleName().equals("Date")){
			Date curDate = (Date)source;
			if(Strings.isNullOrEmpty(date_format)){
				 curObject = DateUtil.format(curDate, DateUtil.PATTERN_YYYY_MM_DD_HH_MM);		 
			 }else {
				 curObject = DateUtil.format(curDate, DateUtil.PATTERN_YYYY_MM_DD_HH_MM);
			}
		 }else{
			 curObject = source.toString();
		 }
		 
		return curObject;
	}
	private static Date StrToDate(String str,String date_format) {
		SimpleDateFormat format = new SimpleDateFormat(date_format);
		//日期保存时统一使用yyyy/MM/dd
		//SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
