package vn.woodsland.byserp.framework.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import vn.woodsland.byserp.framework.validation.annotation.LengthMinWithOutSpace;

public class LengthMinWithOutSpaceValidator implements ConstraintValidator<LengthMinWithOutSpace, String> {
	private int min;

	public void initialize(LengthMinWithOutSpace parameters) {
		min = parameters.min();
		validateParameters();
	}

	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		if (StringUtils.isBlank(value)) {
			return true;
		}
		int length = value.trim().length();
		return length >= min;
	}

	private void validateParameters() {
		if (min < 0) {
			throw new IllegalArgumentException("The min parameter cannot be negative.");
		}

	}

}
