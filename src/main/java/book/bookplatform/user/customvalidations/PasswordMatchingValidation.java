package book.bookplatform.user.customvalidations;

import book.bookplatform.user.dto.UserSignUpRequestModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PasswordMatchingValidation implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return UserSignUpRequestModel.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserSignUpRequestModel object = (UserSignUpRequestModel) target;
        if (!object.getPassword().equals(object.getConfirmpassword()))

           errors.rejectValue("password",null,"Eşleşmeyen Password");


    }
}
