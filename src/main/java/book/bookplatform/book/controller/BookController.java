package book.bookplatform.book.controller;

import book.bookplatform.book.model.BookCreatingModel;
import book.bookplatform.book.model.BookRequestModel;
import book.bookplatform.book.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin("*")
@AllArgsConstructor
public class BookController {
    public static void main(String[] args) {



    }

    private final BookService bookService;

    @PostMapping("books")
    public ResponseEntity saveBook(@Valid @RequestBody BookCreatingModel book) {

        bookService.createBook(book);
        return ResponseEntity.created(null).build();
    }

    @GetMapping("books")
    public ResponseEntity<List<BookRequestModel>> getBooks(@RequestParam(name = "page", required = false, value = "page", defaultValue = "0") int page,
                                                           @RequestParam(name = "size", required = false, value = "size", defaultValue = "30") int size) {

        if (page < 0)
            page = 0;
        if (size > 30)
            size = 30;
        List<BookRequestModel> books = bookService.getBooks(page, size);
        return ResponseEntity.ok(books);
    }


}
