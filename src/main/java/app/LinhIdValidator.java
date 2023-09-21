package app;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LinhIdValidator implements ConstraintValidator<LinhId, String> {
    private static final String LINH_PREFIX = "linh://";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if( value == null || value.isEmpty()) return false;

        return value.startsWith(LINH_PREFIX);
    }
}
