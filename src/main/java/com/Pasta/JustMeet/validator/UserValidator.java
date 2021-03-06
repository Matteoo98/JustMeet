package com.Pasta.JustMeet.validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.Pasta.JustMeet.model.*;
import com.Pasta.JustMeet.service.*;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        if(user.getPassword() != null) {

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
            if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
                errors.rejectValue("password", "Size.userForm.password");
            }

            if (!user.getPasswordConfirm().equals(user.getPassword())) {
                errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
            }
        }

        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognome", "NotEmpty");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "citta", "NotEmpty");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "preferenceUno", "NotEmpty");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "preferenceDue", "NotEmpty");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "preferenceTre", "NotEmpty");
    }
}