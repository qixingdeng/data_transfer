package cn.cttic.roadtransapi.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DatetypeConveterImpl implements IDataConverter{

	@Override
	public Object Converter(Object value) {
		// TODO Auto-generated method stub
		String resString = null ;
		if(value instanceof Calendar){
			Calendar date = (Calendar)value;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			resString = sdf.format(date.getTime());
		}else {
			resString = "";
		}
		
		return resString;
	}

}
