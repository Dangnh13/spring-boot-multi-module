package vn.woodsland.byserp.framework.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import vn.woodsland.byserp.framework.validation.annotation.HalfAlphaNumericSpace;

/**
 * Allow letters, numbers, and spaces _
 *
 */
public class HalfAlphaNumericSpaceValidator implements ConstraintValidator<HalfAlphaNumericSpace, String> {

	public void initialize(HalfAlphaNumericSpace parameters) {
		validateParameters();
	}

	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		if (StringUtils.isBlank(value)) {
			return true;
		}

		String regex = "^[A-Za-z0-9 ]*[A-Za-z0-9][A-Za-z0-9 ]*$";
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(value);

		if (m.find()) {
			return true;
		} else {
			return false;
		}

	}

	private void validateParameters() {
	}
}
