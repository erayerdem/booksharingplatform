package book.bookplatform.book.service;


import book.bookplatform.book.model.Book;
import book.bookplatform.book.model.BookDatabaseModel;
import book.bookplatform.book.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServiceImp implements BookService {

    private final BookRepository bookRepository;

    public void createBook(Book book) {
        BookDatabaseModel bookDatabaseModel = new BookDatabaseModel();

        BeanUtils.copyProperties(book,bookDatabaseModel);
        bookRepository.save(bookDatabaseModel);
    }
}
