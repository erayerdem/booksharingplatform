package book.bookplatform.book.controller;

import book.bookplatform.book.model.Book;
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

    private static String  name;
    private final BookService bookService;

    @PostMapping("books")
    public ResponseEntity responseEntity(@Valid @RequestBody Book book) {


        return ResponseEntity.created(null).build();
    }

    @PostMapping
    public ResponseEntity responseEntity(@RequestBody String test) {

        name = test.toString();
        return ResponseEntity.created(null).build();
    }
    @GetMapping("helegele")
    public  String control(){
        return name;
    }
    @GetMapping("hello")
    public  String helloworld(){
        return  "Hello World";
    }
}
