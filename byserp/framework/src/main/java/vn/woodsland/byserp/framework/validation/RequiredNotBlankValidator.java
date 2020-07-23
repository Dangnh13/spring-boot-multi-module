package vn.woodsland.byserp.framework.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import vn.woodsland.byserp.framework.validation.annotation.RequiredNotBlank;

/**
 * Required Not Blank Validate
 *
 */
public class RequiredNotBlankValidator implements ConstraintValidator<RequiredNotBlank, String> {

	public void initialize(RequiredNotBlank parameters) {
		validateParameters();
	}

	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		if (StringUtils.isNotBlank(value)) {
			return true;
		} else {
			return false;
		}
	}

	private void validateParameters() {
		// Do nothing because don't have value need initialize
	}
}
