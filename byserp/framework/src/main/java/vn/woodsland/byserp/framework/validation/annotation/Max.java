package vn.woodsland.byserp.framework.validation.annotation;

import vn.woodsland.byserp.framework.validation.MaxValidator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = MaxValidator.class)
public @interface Max {

	String name() default "";

	String message() default "Please input {name} less than or equal to {value}.";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default {};

	/**
	 * @return value the element must be lower or equal to
	 */
	long value();

	/**
	 * Defines several <code>@Max</code> annotations on the same element
	 * @see Max
	 *
	 * @author ChungNV
	 */
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		Max[] value();
	}
}
