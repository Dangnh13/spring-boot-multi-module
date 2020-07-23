package vn.woodsland.byserp.framework.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import vn.woodsland.byserp.framework.validation.annotation.Password;

public class PasswordValidator  implements ConstraintValidator<Password, String>{

	private int min;
	private int max;

	public void initialize(Password arg0) {
		min = arg0.min();
		max = arg0.max();
	}

	public boolean isValid(String val, ConstraintValidatorContext arg1) {

		if(StringUtils.isBlank(val)){
			return true;
		}

		int strLen = val.length();

		if(strLen < min || strLen > max){
			return true;
		}
		// Check password with Upper and lower letters and at least one number
		String regexForUpperAndLower = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]){8,})";

		if(checkConditionForPassword(regexForUpperAndLower,val)){
			return true;
		}
		return false;
	}

	private static boolean checkConditionForPassword(String regex, String source){

		Pattern pattern = Pattern.compile(regex);
		Matcher  matcher = pattern.matcher(source);

		if(matcher.find()){
			if (source.contains(" ")) {
				return false;
			}
			return true;
		}

		return false;
	}

}
