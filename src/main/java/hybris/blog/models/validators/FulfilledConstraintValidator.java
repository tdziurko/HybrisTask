package hybris.blog.models.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/*
 * I am using JPA, so I don't want Hibernate dependencies in my models.
 *
 * In order to use this validator, you have to pass max value, min has default set to one
 */

public class FulfilledConstraintValidator implements ConstraintValidator<Fulfilled, String> {
	
	//TODO put params(maxLength,minLength ) into Optional<?>
	
	//values that represent max and min length of parameter. 
	private int maxLength;
	private int minLength;
	
	private String stringToCheck;
	
	public void initialize(Fulfilled fulfilled) {
		this.maxLength = fulfilled.max();
		this.minLength = fulfilled.min();
	}

	public boolean isValid(String stringToCheck, ConstraintValidatorContext arg1) {
		this.stringToCheck = stringToCheck;
		return greaterOrEqualThanMaxLength() && lessOrEqualThanMinLenth();
	}
	
	private boolean greaterOrEqualThanMaxLength(){
		return this.stringToCheck.length() >= this.minLength;
	}
	private boolean lessOrEqualThanMinLenth(){
		return this.stringToCheck.length() <= this.maxLength;
	}
	
}
