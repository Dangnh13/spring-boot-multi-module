package vn.woodsland.byserp.framework.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import vn.woodsland.byserp.framework.validation.annotation.LengthMaxWithOutSpace;


public class LengthMaxWithOutSpaceValidator implements ConstraintValidator<LengthMaxWithOutSpace, String> {
	private int max;
	
	public void initialize(LengthMaxWithOutSpace parameters) {
		max = parameters.max();
		validateParameters();
	}

	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		if (StringUtils.isBlank(value)) {
			return true;
		}
		int length = value.trim().length();

		return length <= max;
	}

	private void validateParameters() {
		if ( max < 0 ) {
			throw new IllegalArgumentException( "The max parameter cannot be negative." );
		}
	}

}
