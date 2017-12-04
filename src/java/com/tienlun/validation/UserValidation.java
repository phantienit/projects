/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienlun.validation;

import com.tienlun.model.Users;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.apache.commons.validator.routines.EmailValidator;
/**
 *
 * @author tienpv
 */
public class UserValidation implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Users.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object object, Errors errors) {
        Users user = (Users) object;

        if (user.getUserName().length() == 0) {
            errors.rejectValue("userName", "NotEmpty");
        }

        if (user.getEmail().length() == 0) {
            errors.rejectValue("userEmail", "NotEmpty");
        } else if (EmailValidator.getInstance().isValid(user.getEmail()) == false) {
            errors.rejectValue("userEmail", "Error.Email.Format");
        }

        if (user.getPassword().length() == 0) {
            errors.rejectValue("userPass", "NotEmpty");
        } else if (user.getPassword().length() < 5 || user.getPassword().length() > 20) {
            errors.rejectValue("userPass", "Error.Pass.Size");
        }
        
    }

}
