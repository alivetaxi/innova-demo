package com.innova.demo.validate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.innova.demo.utils.Constants;
import com.innova.demo.validate.validator.SameSequenceFollowedValidator;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SameSequenceFollowedValidator.class)
@Documented
public @interface SameSequenceFollowed {

	String message() default Constants.SAME_SEQUENCE_FOLLOWED_MESSAGE;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
