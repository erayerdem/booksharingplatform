package book.bookplatform.user.controller;

import book.bookplatform.book.repository.BookRepository;
import book.bookplatform.user.customvalidation.EmailValidator;
import book.bookplatform.user.customvalidation.PasswordMatchingValidation;
import book.bookplatform.user.model.UserSignUpRequestModel;
import book.bookplatform.user.repository.UserRepository;
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


    private final UserService userService;
    private final PasswordMatchingValidation passwordMatchingValidation;
    private final EmailValidator emailValidator;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @InitBinder
    final protected void databinding(final WebDataBinder webDataBinder) {
        webDataBinder.addValidators(passwordMatchingValidation, emailValidator);

    }


    @PostMapping("users")
    public ResponseEntity createUser(@RequestBody @Valid UserSignUpRequestModel userSignUpRequestModel) {

        userService.createUser(userSignUpRequestModel);
        return ResponseEntity.created(null).build();
    }


}


