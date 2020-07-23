package vn.woodsland.byserp.framework.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import vn.woodsland.byserp.framework.validation.annotation.RequiredNotSpace;

/**
 * Required Not Blank Validate
 *
 */
public class RequiredNotSpaceValidator implements ConstraintValidator<RequiredNotSpace, String> {

	public void initialize(RequiredNotSpace parameters) {
		validateParameters();
	}

	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		if (StringUtils.isNotBlank(value.trim())) {
			return true;
		} else {
			return false;
		}
	}

	private void validateParameters() {
		// Do nothing because don't have value need initialize
	}
}
