package book.bookplatform;

import book.bookplatform.user.model.UserDatabaseModel;
import book.bookplatform.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@AllArgsConstructor
public class BookplatformApplication {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(BookplatformApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {

        return args -> {
            UserDatabaseModel userDatabaseModel = new UserDatabaseModel();
            userDatabaseModel.setEmail("sameterayerdm@gmail.com");
            userDatabaseModel.setEncryptedpassword(passwordEncoder.encode("samet"));

            userRepository.save(userDatabaseModel);
        };
    }
}
