/*
 * Project: RDTRANS
 * Copyright 2015 CTTIC
 * All right reserved.
 */
package cn.cttic.roadtransapi.converter;

import java.util.List;
import java.util.TimeZone;

import com.google.common.collect.Lists;
import com.thoughtworks.xstream.converters.basic.DateConverter;

/**
 * 建立日期 : 2015-8-4 下午4:25:24<br>
 * 作者 : liuzhenliang@cttic.cn<br>
 * 模块 : <br>
 * 描述 : <br>
 * 修改历史 <br>
 * 序号 日期 修改人 修改原因 <br>
 * 1 <br>
 * 2 <br>
 */
public class MyDateConverter  extends DateConverter
{
	public MyDateConverter(String defaultFormat ,String[] acceptableFormats,TimeZone temptimeZone){
		super(defaultFormat ,acceptableFormats,temptimeZone);
		
	    
	}
	
	public static MyDateConverter Create() {
		String defaultFormat ="yyyy-MM-dd HH:mm:ss" ; 
		List<String> acceptablePatterns = Lists.newArrayList();
		acceptablePatterns.add("yyyy-MM-dd HH:mm:ss");
		String[] acceptableFormats = (String[]) acceptablePatterns.toArray(new String[acceptablePatterns.size()]);
		
	    TimeZone temptimeZone = TimeZone.getDefault();
	    
	    return new MyDateConverter(defaultFormat,acceptableFormats,temptimeZone);
	}
}
