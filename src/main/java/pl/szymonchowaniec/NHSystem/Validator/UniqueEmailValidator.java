package pl.szymonchowaniec.NHSystem.Validator;

import javax.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import pl.szymonchowaniec.NHSystem.Service.MemberService;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
//
//    @Autowired
//    private MemberService userService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null; //&& !userService.findOne(value);
    }

}
