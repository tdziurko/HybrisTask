package hybris.blog.models.validators;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FulfilledConstraintValidator.class)
public @interface Fulfilled {
		
	String message();
	
	int max();
	
	int min() default 1;
	
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
