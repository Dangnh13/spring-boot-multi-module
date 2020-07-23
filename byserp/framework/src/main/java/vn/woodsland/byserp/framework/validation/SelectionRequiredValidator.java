package vn.woodsland.byserp.framework.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import vn.woodsland.byserp.framework.validation.annotation.SelectionRequired;

/**
 * Selection required Validate
 *
 */
public class SelectionRequiredValidator implements ConstraintValidator<SelectionRequired, String> {

	public void initialize(SelectionRequired parameters) {
		validateParameters();
	}

	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		if (StringUtils.isNotBlank(value) && !value.equals("-1")) {
			return true;
		} else {
			return false;
		}
	}

	private void validateParameters() {
		// Do nothing because don't have value need initialize
	}
}
