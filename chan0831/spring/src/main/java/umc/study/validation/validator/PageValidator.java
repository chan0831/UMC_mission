package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.validation.annotation.ExistPage;

public class PageValidator implements ConstraintValidator<ExistPage, Integer> {

    @Override
    public void initialize(ExistPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext context) {
        if(page == null || page<1){

            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_NOT_FOUND.getMessage()).addConstraintViolation();

            return false;
        }
        return true;

    }
}
