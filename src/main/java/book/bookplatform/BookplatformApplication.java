package book.bookplatform;

import book.bookplatform.user.customvalidation.PasswordMatchingValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BookplatformApplication {


    public static void main(String[] args) {
        SpringApplication.run(BookplatformApplication.class, args);
    }


}
