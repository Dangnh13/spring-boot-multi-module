package vn.woodsland.byserp.framework.validation;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import vn.woodsland.byserp.framework.validation.annotation.Decimal;

/**
 * Decimal check
 *
 */
public class DecimalValidator implements ConstraintValidator<Decimal, String> {

	private int numberOfInt;
	private int numberOfDecimal;

	public void initialize(Decimal parameters) {

		numberOfInt = parameters.numberOfInt();
		numberOfDecimal = parameters.numberOfDecimal();

		validateParameters();
	}

	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		if (StringUtils.isBlank(value)) {
			return true;
		}

		String regex = "^(\\d+)(\\.\\d+)?$";
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(value);

		if (m.find()) {
			BigDecimal b = new BigDecimal(value);

			if (b.precision() - b.scale() > numberOfInt) {
				return false;
			} else if (b.scale() > numberOfDecimal) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}

	}

	private void validateParameters() {
	}
}
