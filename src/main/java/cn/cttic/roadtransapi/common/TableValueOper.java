package cn.cttic.roadtransapi.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import cn.cttic.roadtransapi.common.SortableFieldList.TableValue;
import cn.cttic.roadtransapi.mgr.ConvterDataMgr;
import cn.cttic.roadtransapi.mgr.CrmReflectMgr;
import cn.cttic.sysframe.common.util.DateUtil;
import cn.cttic.sysframe.common.util.bean.BeanCopyUtil;

import com.google.common.collect.Lists;

// import cn.cttic.sysframe.common.util.bean.DateConverterOfBeanUtils;

public class TableValueOper {

	// private static final Logger LOG = LoggerFactory.getLogger(SortableFieldList.class);
	public final static List<String> CheckObject(Object source , Class<?> type ) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		List<String> list = Lists.newArrayList();
		if(source!=null){
			Field[] fields = type.getDeclaredFields();
			
			for (Field field : fields) {
				Object origField = BeanUtils.getProperty(source, field.getName());
				if (origField == null){
					list.add(field.getName());
				}else{
					if (origField instanceof String && ((String) origField).trim().equals("")){
						list.add(field.getName());
					}
				}
					
			}
		}
		return list;
	}
	
	
	public final static int SetValue(Object dest, Object orig, Class<?> mappertype) {
		int ret = -1;
		if (dest == null || orig == null) {
			return ret;
		}

		String name = mappertype.getSimpleName();
		SortableFieldList list = CrmReflectMgr.getInstance().GetField(name);
		if (list != null && list.size() > 0) {
			List<TableValue> diffList = list.getTableList(mappertype.getSimpleName());
			if (diffList != null && diffList.size() > 0) {
				for (TableValue sortableField : diffList) {
					if (sortableField.getTableName().equals(mappertype.getSimpleName())) {

						try {
							Object origField = BeanUtils.getProperty(orig, sortableField.getTableValue());
							if (origField == null)
								continue;
							if (origField != null) {
								if (origField instanceof String && ((String) origField).trim().equals(""))
									continue;
							}

							String obj = null;

							if (sortableField.getConvterkey() != null && !sortableField.getConvterkey().equals("")) {
								String setfunc = sortableField.getTableValue();
								setfunc = "get" + setfunc.substring(0, 1).toUpperCase() + setfunc.substring(1);
								Method mm = orig.getClass().getMethod(setfunc);

								if (mm != null) {
									Object source = mm.invoke(orig);
									obj = (String) ConvterDataMgr.getInstance().Conveter(sortableField.getConvterkey(), source);
								}

							} else {
								obj = (String) origField;
							}

							BeanUtils.setProperty(dest, sortableField.getTargetName(), obj);
							ret = 0;

						}
						catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							ret = -1;

						}
						catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							ret = -1;
						}
						catch (NoSuchMethodException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							ret = -1;
						}
						catch (Exception e) {
							e.printStackTrace();
							ret = -1;
						}
						finally {

						}

					}
				}
			}

		}

		ret = 0;
		return ret;
	}

	public final static int SetValue(Object dest, Object orig, List<String> fieldNames) {
		BeanCopyUtil.copyNonEmptyProperties(dest, orig, fieldNames);
		return 0;
	}
	
	public final static void GetClassField(Object orig,List<String> fieldlist){
		
		Class<?> clazz = orig.getClass();
		for(; clazz != Object.class; clazz = clazz.getSuperclass()) {
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				fieldlist.add(field.getName());
			}
		}
	}
	
	 public static Field getDeclaredField(Object object, String fieldName){
	        Field field = null;
	        Class<?> clazz = object.getClass();
	        for(; clazz != Object.class; clazz = clazz.getSuperclass()) {
	            try {
	                return  field = clazz.getDeclaredField(fieldName);
	            } catch (Exception e) {
	                
	            }
	        }
	        return null;
	 }
	
	 
	 public static Method getDeclaredMethod(Object object, String fieldName){
		 	Method field = null;
	        Class<?> clazz = object.getClass();
	        for(; clazz != Object.class; clazz = clazz.getSuperclass()) {
	            try {
	            	for (Method method : clazz.getDeclaredMethods()) {
						if(method.getName().equals(fieldName)){
							field = method;
						}
					}
	            	
	              
	            } catch (Exception e) {
	                
	            }
	        }
	        
	        return  field ;
	 }
	 
	 
	 public static void setFieldValue(Object orig, String field, Object value){
		 
		 	String setfunc = "set" + field.substring(0, 1).toUpperCase() + field.substring(1);
		 	Method setMethod = getDeclaredMethod(orig,setfunc);
		 	if(setMethod!=null){
				try {
					setMethod.invoke(orig, value);
					
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	    }
	 
	 public static String GetValueName(String field){
		 return field.substring(0, 1).toUpperCase() + field.substring(1);
	 }
	 
	 public static Object getFieldValue(Object orig, String field){
		 
		 	String getfunc = "get" + field.substring(0, 1).toUpperCase() + field.substring(1);
		 	Method getMethod = getDeclaredMethod(orig,getfunc);
		 	Object valueObject = null;
		 	
		 	if(getMethod!=null){
				try {
					 valueObject = getMethod.invoke(orig, null);
					
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		 	
		 	return valueObject ; 
	    }
	 
	public final static int SetValue(Object dest, Object orig) {
		int ret = -1 ;
		List<String> fieldlist = Lists.newArrayList();
		GetClassField(orig,fieldlist);
		
		for (String field : fieldlist) {
			
			Object valueObject = getFieldValue(orig,field);
			if(valueObject!=null){
				setFieldValue(dest,field,valueObject);
			}
		}
		
		
		return ret;
	}

	public final static int GetValue(Object source, Map<String, String> map) {

		if (source != null) {
			Field[] fields = source.getClass().getDeclaredFields();
			Method m = null;
			Object value = null;
			for (Field field : fields) {
				String name = field.getName();
				String getname = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
				try {
					m = field.getDeclaringClass().getMethod(getname);
				}
				catch (NoSuchMethodException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				catch (SecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (m != null) {
					try {
						value = m.invoke(source);
					}
					catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (value != null) {
						
						if(value instanceof Date){
							 java.util.Date curDate =(Date) value;
							 map.put(name, DateUtil.format(curDate, DateUtil.PATTERN_YYYY_MM_DD_HH_MM_SS));
							 
						 }else{
							 map.put(name, String.valueOf(value));
						 }
						
					}
				}
			}
		}
		return 0;
	}

	public final static int SetValue(Object source, Map<String, String> map) {
		if (source != null) {
			Field[] fields = source.getClass().getDeclaredFields();
			Method m = null;

			for (Field field : fields) {

				String name = field.getName();

				if (map.containsKey(name)) {
					String mapvalue = map.get(name);
					String setname = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
					try {
						m = field.getDeclaringClass().getMethod(setname);
					}
					catch (NoSuchMethodException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					catch (SecurityException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					if (m != null) {
						try {
							m.invoke(source, mapvalue);
						}
						catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

			}
		}
		return 0;
	}
}
