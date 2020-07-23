package vn.woodsland.byserp.framework.validation.annotation;

import vn.woodsland.byserp.framework.validation.MinValidator;

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
@Constraint(validatedBy = MinValidator.class)
public @interface Min {

	String name() default "";

	String message() default "{name} must be greater than or equal to {value}.";

	Class<?>[]groups() default {};

	Class<? extends Payload>[]payload() default {};

	/**
	 * @return value the element must be higher or equal to
	 */
	long value();

	/**
	 * Defines several <code>@Min</code> annotations on the same element
	 *
	 * @see Min
	 *
	 * @author ChungNV
	 */
	@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		Min[]value();
	}
}
