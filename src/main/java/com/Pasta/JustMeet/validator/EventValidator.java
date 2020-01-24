/**
 * 
 */
package com.Pasta.JustMeet.validator;
import java.time.LocalDateTime;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.Pasta.JustMeet.model.*;


@Component
public class EventValidator implements Validator {
    
    LocalDateTime now = LocalDateTime.now();
    

    @Override
    public boolean supports(Class<?> aClass) {
        return Events.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Events event = (Events) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Year", "NotEmpty");
        if ( event.getYear()<now.getYear()) {
            errors.rejectValue("Year", "Size.eventForm.Year");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Month", "NotEmpty");
        if (event.getMonth() < 1 || event.getMonth() > 12 ) {
            errors.rejectValue("Month", "Size.eventForm.Month");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Day", "NotEmpty");
        if (event.getDay() < 1 || event.getDay() > 31 ) {
            errors.rejectValue("Day", "Size.eventForm.Day");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Ora", "NotEmpty");
        if (event.getOra() < 0 || event.getOra() > 23 ) {
            errors.rejectValue("Ora", "Size.eventForm.Ora");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Minuti", "NotEmpty");
        if (event.getMinuti() < 0 || event.getMinuti() > 59 ) {
            errors.rejectValue("Minuti", "Size.eventForm.Minuti");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category", "NotEmpty");
        /*if (event.getCategory() != "Sport" & event.getCategory() != "Studio" & event.getCategory() != "Giochi" ) {
            errors.rejectValue("category", "Error.eventForm.category");
        }*/
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "luogo", "NotEmpty");
        
        

        
    }
}