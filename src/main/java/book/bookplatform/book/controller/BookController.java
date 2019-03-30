package book.bookplatform.book.controller;

import book.bookplatform.book.model.Book;
import book.bookplatform.book.repository.BookRepository;
import book.bookplatform.book.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api")
@CrossOrigin("*")
@AllArgsConstructor
public class BookController {


    private final BookService bookService;

    @PostMapping("books")
    public ResponseEntity responseEntity(@Valid @RequestBody Book book) {


        return ResponseEntity.created(null).build();
    }


}
