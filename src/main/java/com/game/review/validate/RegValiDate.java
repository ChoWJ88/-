package com.game.review.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.game.review.command.GameRegCommand;
import com.game.review.command.GameSpecCommand;

public class RegValiDate implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		GameRegCommand grc = (GameRegCommand) target;
		if (grc.getImgFile().isEmpty()) {
			errors.rejectValue("imgFile", "noImage");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gName", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gCode", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gDev", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genNum", "required");
		ValidationUtils.rejectIfEmpty(errors, "imgFile", "noImage");
	}

}
