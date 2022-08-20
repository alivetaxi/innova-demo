package com.innova.demo.validate.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ContentMixtureValidatorTest {

	private ContentMixtureValidator validator = new ContentMixtureValidator();

	@Nested
	class ValidFlow {
		@Test
		void shouldReturnTrue() {
			assertTrue(isValid("1qaz2wsx"));
			assertTrue(isValid("zaq1xsw2"));
			assertTrue(isValid("1111qqqq"));
			assertTrue(isValid("wwww2222"));
			assertTrue(isValid("1q2w3e4r"));
		}
	}

	@Nested
	class InvalidFlow {
		@Test
		void ishouldReturnFalse() {
			assertFalse(isValid(null));
			assertFalse(isValid(""));
			assertFalse(isValid("1qaz@^&*wsx"));
			assertFalse(isValid("1qaz2WSX"));
			assertFalse(isValid("2wsx測試"));
		}
	}

	private boolean isValid(String value) {
		return validator.isValid(value, null);
	}

}