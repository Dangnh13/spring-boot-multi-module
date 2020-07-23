package vn.woodsland.byserp.framework.validation;

import java.io.UnsupportedEncodingException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import vn.woodsland.byserp.framework.validation.annotation.ByteLength;

public class ByteLengthValidator implements ConstraintValidator<ByteLength, String> {
	private int byteLength;
	private String encode;

	public void initialize(ByteLength parameters) {
		byteLength = parameters.byteLength();
		encode = parameters.encode();
		validateParameters();
	}

	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		
		if (StringUtils.isBlank(value)) {
			return true;
		}
		
		try {
			return value.getBytes(encode).length <= byteLength;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		}
	}

	private void validateParameters() {
		if (byteLength < 0) {
			throw new IllegalArgumentException("The byteLength parameter cannot be negative.");
		}
	}
}
