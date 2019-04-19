package book.bookplatform.book.controller;

import book.bookplatform.book.model.Book;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api")
@CrossOrigin("*")
@AllArgsConstructor
public class BookController {


    @PostMapping("books")
    public ResponseEntity responseEntity(@Valid @RequestBody Book book) {


        return ResponseEntity.created(null).build();
    }

}
