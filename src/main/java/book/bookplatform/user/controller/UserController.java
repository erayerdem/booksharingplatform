package book.bookplatform.user.controller;

import book.bookplatform.user.customvalidation.EmailValidator;
import book.bookplatform.user.customvalidation.PasswordMatchingValidation;
import book.bookplatform.user.model.UserDatabaseModel;
import book.bookplatform.user.model.UserSignUpRequestModel;
import book.bookplatform.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("api")
@CrossOrigin("*")
public class UserController {
    private final PasswordMatchingValidation passwordMatchingValidation;
    private final EmailValidator emailValidator;

    @InitBinder
    protected void databinding(final WebDataBinder webDataBinder) {
        webDataBinder.addValidators(passwordMatchingValidation, emailValidator);

    }

    private final UserService userService;

    @PostMapping("users")
    public ResponseEntity createUser(@RequestBody @Valid UserSignUpRequestModel userSignUpRequestModel) {

        UserDatabaseModel userDatabaseModel = new UserDatabaseModel();
        userService.createUser(userSignUpRequestModel);
        return ResponseEntity.created(null).build();
    }

    @GetMapping
    public String test() {

        return "spring security succes";
    }

}


