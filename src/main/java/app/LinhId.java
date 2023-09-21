package app;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = LinhIdValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LinhId {

    String message() default "must start with linh";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
