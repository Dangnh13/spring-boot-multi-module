package vn.woodsland.byserp.framework.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import vn.woodsland.byserp.framework.validation.annotation.HhMm;

/**
 * HH:mm validator
 *
 */
public class HhMmValidator implements ConstraintValidator<HhMm, String> {

	public void initialize(HhMm parameters) {
		validateParameters();
	}

	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		if (StringUtils.isBlank(value)) {
			return true;
		}

		String regex = "^(((([0-1][0-9])|(2[0-3])):[0-5][0-9])|(24:00))$";
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
