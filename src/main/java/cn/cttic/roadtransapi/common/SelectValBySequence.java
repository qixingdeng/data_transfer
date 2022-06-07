package cn.cttic.roadtransapi.common;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface SelectValBySequence {
	
	/**
	 * 需要对应的sequence类
	 * @return
	 */
	String SequenceName() default "";
}
