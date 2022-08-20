package com.innova.demo.validate.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CharLengthValidatorTest {

	private CharLengthValidator validator = new CharLengthValidator();

	@Nested
	class ValidFlow {
		@Test
		void shouldReturnTrue() {
			assertTrue(isValid("qazwsx"));
			assertTrue(isValid("1qaz2wsx3edc"));
		}
	}

	@Nested
	class InvalidFlow {
		@Test
		void ishouldReturnFalse() {
			assertFalse(isValid(null));
			assertFalse(isValid(""));
			assertFalse(isValid("1qaz"));
			assertFalse(isValid("1qaz2wsx3edc4rfv"));
		}
	}

	private boolean isValid(String value) {
		return validator.isValid(value, null);
	}

}