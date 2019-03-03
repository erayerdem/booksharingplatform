package book.bookplatform;

import book.bookplatform.user.customvalidations.PasswordMatchingValidation;
import book.bookplatform.user.dto.UserSignUpRequestModel;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@SpringBootApplication
@RestController
@AllArgsConstructor
public class BookplatformApplication {
    private final PasswordMatchingValidation passwordMatchingValidation;

    @InitBinder
    protected void bindUserSignUpRequestModel(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(passwordMatchingValidation);

    }

    public static void main(String[] args) {
        SpringApplication.run(BookplatformApplication.class, args);
    }


    @PostMapping
    public  void  creatEntity(@Valid @RequestBody  UserSignUpRequestModel userSignUpRequestModel, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            System.out.println(bindingResult.getFieldError().getDefaultMessage()+" "+bindingResult.getErrorCount());
    }


}
