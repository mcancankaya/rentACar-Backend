package com.mcancankaya.rentacar.core.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.ValidationException;

public class EnumCheckValidator implements ConstraintValidator<EnumCheck, String> {
    private Enum<?>[] values;

    @Override
    public void initialize(EnumCheck constraintAnnotation) {
        Class<? extends Enum<?>> enumClass = constraintAnnotation.enumClass();
        values = enumClass.getEnumConstants();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        for (Enum<?> enumValue : values) {
            if (enumValue.name().equals(s)) {
                return true;
            }
        }
        return false;
    }
}
