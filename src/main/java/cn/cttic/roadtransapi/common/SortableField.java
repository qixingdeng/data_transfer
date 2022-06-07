package cn.cttic.roadtransapi.common;

import java.lang.reflect.Field;


public class SortableField {  
	  
    public SortableField(){}  
      
    public SortableField(IntfFieldMeta meta, Field field) {  
        super();  
        this.meta = meta;  
        this.field = field;  
        this.name=field.getName();  
        this.type=field.getType();  
    }  
      
    public SortableField( Field field) {  
        super();  
        this.field = field;  
        this.name=field.getName();  
        this.type=field.getType();  
    }   
    
    public SortableField(IntfFieldMeta meta, String name, Class<?> type) {  
        super();  
        this.meta = meta;  
        this.name = name;  
        this.type = type;  
    }  
  
  
    private IntfFieldMeta meta; 
    private IntfFieldMetaArray metaArray ;
    private IntfFieldConvterMeta intfFieldConvterMeta;
    private Field field;  
    private String name;  
    private Class<?> type;  
      
    public IntfFieldMeta getMeta() {  
        return meta;  
    }  
    public void setMeta(IntfFieldMeta meta) {  
        this.meta = meta;  
    }  
    public Field getField() {  
        return field;  
    }  
    public void setField(Field field) {  
        this.field = field;  
    }  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public Class<?> getType() {  
        return type;  
    }  
  
    public void setType(Class<?> type) {  
        this.type = type;  
    }

	public IntfFieldMetaArray getMetaArray() {
		return metaArray;
	}

	public void setMetaArray(IntfFieldMetaArray metaArray) {
		this.metaArray = metaArray;
	}

	public IntfFieldConvterMeta getIntfFieldConvterMeta() {
		return intfFieldConvterMeta;
	}

	public void setIntfFieldConvterMeta(IntfFieldConvterMeta intfFieldConvterMeta) {
		this.intfFieldConvterMeta = intfFieldConvterMeta;
	}  
      
      
}  