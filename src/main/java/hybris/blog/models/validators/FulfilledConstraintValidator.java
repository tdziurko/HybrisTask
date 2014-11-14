package hybris.blog.models.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/*
 *I am using JPA, so I don't want Hibernate dependencies in my models.
 */

public class FulfilledConstraintValidator implements ConstraintValidator<Fulfilled, String> {
		
	public void initialize(Fulfilled string) {}

	public boolean isValid(String stringToCheck, ConstraintValidatorContext arg1) {
		// TODO add, possibility to deliver metadata(eg. size, min, max)
		return stringToCheck.length() >= 1 && stringToCheck.length() <= 45;
	}

}
