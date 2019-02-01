package pl.szymonchowaniec.NHSystem.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String>{

//    @Autowired
//    private LibraryUserDetailService userService;
//
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null; //&& !userService.isUsernameAlreadyInUse(value);
    }
}
