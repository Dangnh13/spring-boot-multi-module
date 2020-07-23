package vn.woodsland.byserp.framework.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import vn.woodsland.byserp.framework.validation.annotation.SpecialCharacters;

/**
 * Special Characters Validator check
 * Deny special characters !@#$%&*()_+=|<>?{}\\[\\]~-
 */
public class SpecialCharactersValidator implements ConstraintValidator<SpecialCharacters, String> {

	public void initialize(SpecialCharacters parameters) {
		validateParameters();
	}

	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		if (StringUtils.isBlank(value)) {
			return false;
		}

		String regex = "[!@#$%&*()_+=|<>?{}\\[\\]~-]";// /^[a-zA-Z ]*$/
		
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(value);

		if (m.find()) {
			return false;
		} else {
			return true;
		}

	}

	private void validateParameters() {
		// Do nothing because don't have value need initialize
	}
}
