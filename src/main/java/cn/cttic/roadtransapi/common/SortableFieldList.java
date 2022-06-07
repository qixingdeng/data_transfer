package cn.cttic.roadtransapi.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class SortableFieldList extends ArrayList<SortableField> {  
	  
	private static final Logger LOG = LoggerFactory.getLogger(SortableFieldList.class);
	
	private static final long serialVersionUID = -9144877712855292409L;

	public SortableFieldList(Class<?>  typeClass)
	{
		setLocaltypeClass(typeClass);
	}  
      
	public void InitFileldList() {
	
		mapvaluelist.clear() ;
		
		IntfFieldMeta meta = null;
		IntfFieldMetaArray metaArray = null ;
		
		LOG.debug("SortableField type :  "+ localtypeClass.getSimpleName()+" [ "+ this.size()+"]");
		for (SortableField field : this) {
			 meta = field.getMeta() ;
			if ( meta != null) {
				if (meta.isProcess()) {
					LOG.debug("SBoss4FieldMeta field :  "+ field.getName(),"TableMapperName:"+meta.TableMapperName()+"TablePropertyKey:"+meta.TablePropertyKey());
					
					setKeyValue(meta.TableMapperName(),meta.TablePropertyKey(),field);
				}else {
					LOG.debug("field isProcess is false :  [" + field.getName()+"];");
				}
			}
			
			
			metaArray = field.getMetaArray() ;	
			if(metaArray != null){
				String [] TableMapperNameArray = metaArray.TableMapperNameArray() ;
				String [] TablePropertyKeyArray =metaArray.TablePropertyKeyArray();
				LOG.debug("SortableField type :  "+ localtypeClass.getSimpleName()+" TableMapperNameArray:[ "+TableMapperNameArray.length+"]");
				LOG.debug("SortableField type :  "+ localtypeClass.getSimpleName()+" TablePropertyKeyArray:[ "+TablePropertyKeyArray.length+"]");
		
				for(int i = 0 ; i <  TableMapperNameArray.length; i ++ ){
     				if(i > TablePropertyKeyArray.length -1 ){
     					LOG.debug("SBoss4FieldMetaArray field :  "+ field.getName(),"TableMapperName:"+TableMapperNameArray[i]);
    			
     					setKeyValue(TableMapperNameArray[i],"",field);
     				}else{
     					
     					LOG.debug("SBoss4FieldMetaArray field :  "+ field.getName(),"TableMapperName:"+TableMapperNameArray[i]+"TablePropertyKey:"+TablePropertyKeyArray[i]);
    					
     					setKeyValue(TableMapperNameArray[i],TablePropertyKeyArray[i],field);
     				}
     				
     			}
				
     			
			}
		}
	}
	
	private  void  setKeyValue(String tableMapperName, String  tablePropertyKey,SortableField field){
		 
		 if(tablePropertyKey.length() == 0){
			 tablePropertyKey=field.getField().getName();
		 }
		 
		 List<TableValue> tableValuefieldList = mapvaluelist.get(tableMapperName);
		 if(tableValuefieldList == null){
			 tableValuefieldList= new ArrayList<TableValue>() ;
			 mapvaluelist.put(tableMapperName, tableValuefieldList);
		 }
		 
    	 TableValue key = new TableValue();
    	 key.setField(field);
    	 key.setTableName(tableMapperName);
    	 key.setTableValue(tablePropertyKey);
    	 key.setTargetName(field.getName());
    	 if(field.getIntfFieldConvterMeta()!=null){
    		 key.setConvterkey(field.getIntfFieldConvterMeta().IntfFieldConvterName());
    	 }
    	 
    	 
    	 boolean sign = SetConvter(key,field.getField().getName());
    	 if(!sign){
    		 String Log = "Class : ["+this.getLocaltypeClass().getSimpleName() + "]" + "field:["+field.getField().getName()+"] is false !!";
    		 LOG.debug(Log);
    	 }
    	 
    	 tableValuefieldList.add(key);
    	 
	}

	
	public List<TableValue> getTableList(String TableMapperName){
		return mapvaluelist.get( TableMapperName);
	}
		
	public Class<?> getLocaltypeClass() {
		return localtypeClass;
	}


	private void setLocaltypeClass(Class<?> localtypeClass) {
		this.localtypeClass = localtypeClass;
	}

	private Class<?>  localtypeClass ;
	
	
	private HashMap<String, List<TableValue>> mapvaluelist = new HashMap<String,List<TableValue>>() ;
	
	private boolean SetConvter(TableValue key,String fieldName){
		boolean sign = false ;
		
	
		
		return sign ;
	}
	
	public class TableValue{
		private String TableName ;
		private String TableValue;
		private String  TargetName;
		private SortableField field;
		private String Convterkey ;
		public String getTableName() {
			return TableName;
		}
		public void setTableName(String tableName) {
			TableName = tableName;
		}
		public String getTableValue() {
			return TableValue;
		}
		public void setTableValue(String tableValue) {
			TableValue = tableValue;
		}
		public SortableField getField() {
			return field;
		}
		public void setField(SortableField field) {
			this.field = field;
		}
		public String getTargetName() {
			return TargetName;
		}
		public void setTargetName(String targetName) {
			TargetName = targetName;
		}
		public String getConvterkey() {
			return Convterkey;
		}
		public void setConvterkey(String convterkey) {
			Convterkey = convterkey;
		}
		
	}
	
		
}  