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



    @PostMapping("books")
    public ResponseEntity responseEntity(@Valid @RequestBody Book book) {


        return ResponseEntity.created(null).build();
    }

    public static void main(String[] args) {
        CharSequence a="21";
        System.out.println(a.getClass());
        String A="21".substring(0);
        System.out.println(A==a);
    }
}
