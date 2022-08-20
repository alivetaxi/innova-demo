package com.innova.demo.validate.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.innova.demo.validate.ContentMixture;

public class ContentMixtureValidator implements ConstraintValidator<ContentMixture, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (null == value)
			return false;

		int dcnt = 0, acnt = 0;

		char v;
		for (int i = 0; i < value.length(); i++) {
			v = value.charAt(i);
			if (v >= '0' && v <= '9')
				dcnt++;
			if (v >= 'a' && v <= 'z')
				acnt++;
		}

		if (0 == dcnt || 0 == acnt) // no lowercase letters or no numerical digits
			return false;
		if (value.length() != dcnt + acnt) // contains something other than lowercase letters or numerical digits
			return false;

		return true;
	}

}
