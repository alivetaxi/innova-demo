package com.innova.demo.validate.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.innova.demo.validate.CharLength;

public class CharLengthValidator implements ConstraintValidator<CharLength, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (null == value)
			return false;

		int length = value.length();
		return length >= 5 && length <= 12;
	}

}
