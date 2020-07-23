package vn.woodsland.byserp.framework.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import vn.woodsland.byserp.framework.validation.annotation.LengthMax;


public class LengthMaxValidator implements ConstraintValidator<LengthMax, String> {
	private int max;
	
	public void initialize(LengthMax parameters) {
		max = parameters.max();
		validateParameters();
	}

	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		if (StringUtils.isBlank(value)) {
			return true;
		}
		
		int length = value.length();
		
		return length <= max;
	}

	private void validateParameters() {
		if ( max < 0 ) {
			throw new IllegalArgumentException( "The max parameter cannot be negative." );
		}
	}

}
