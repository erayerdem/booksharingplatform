package book.bookplatform;

import book.bookplatform.book.model.BookDatabaseModel;
import book.bookplatform.book.repository.BookRepository;
import book.bookplatform.user.model.UserDatabaseModel;
import book.bookplatform.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@SpringBootApplication
@RestController
@AllArgsConstructor
public class BookplatformApplication {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(BookplatformApplication.class, args);
    }


    @Bean
    CommandLineRunner addduser() {
        return (args -> {

            UserDatabaseModel userDatabaseModel = new UserDatabaseModel();
            userDatabaseModel.setEmail("sameterayerdm@gmail.com");
            userDatabaseModel.setEncryptedpassword(passwordEncoder.encode("samet"));
            userRepository.save(userDatabaseModel);
        });

    }

    @Bean
    CommandLineRunner addBook() {

        return (args -> {
            Arrays.asList(new BookDatabaseModel(1L, "samet", "eray", 100, "xx", "ozet", null),
                    new BookDatabaseModel(2L, "ahmet", "eray", 100, "xx", "ozet", null))
                    .forEach(bookDatabaseModel -> bookRepository.save(bookDatabaseModel));

        });

    }
}
