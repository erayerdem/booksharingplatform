package book.bookplatform.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @GetMapping
    public ResponseEntity responseEntity() {
        return new ResponseEntity("Succes Login", HttpStatus.OK);
    }
}
