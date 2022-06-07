package cn.cttic.roadtransapi.common;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface	IntfFieldMeta {
	/** 
     * 是否为需要处理
     * @return 
     */  
	boolean isProcess() default true ;

	/** 
     * 需要对应的表的mapper的属性名
     * @return 
     */  
	String TablePropertyKey() default "" ;
	
	/** 
     * 需要对应的mapper的类
     * @return 
     */  
	String TableMapperName() default "";
	
	
	/** 
     * index
     * @return 
     */  
	int  TableMapperIndex() default -1 ;
	
}