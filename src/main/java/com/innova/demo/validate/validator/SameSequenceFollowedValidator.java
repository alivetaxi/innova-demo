package com.innova.demo.validate.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.innova.demo.validate.SameSequenceFollowed;

public class SameSequenceFollowedValidator implements ConstraintValidator<SameSequenceFollowed, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (null == value || 4 > value.length())
			return true;

		String subStr;
		for (int i = 0; i < value.length() - 2; i++) {
			for (int j = i + 2; j <= value.length(); j++) {
				if (j - i <= value.length() / 2) {
					subStr = value.subSequence(i, j).toString();
					if (value.contains(subStr + subStr))
						return false;
				}
			}
		}

		return true;
	}

}
