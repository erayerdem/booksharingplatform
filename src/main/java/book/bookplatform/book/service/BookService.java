package book.bookplatform.book.service;

import book.bookplatform.book.model.BookCreatingModel;
import book.bookplatform.book.model.BookRequestModel;

import java.util.List;

public interface BookService {

    void createBook(BookCreatingModel book);

    List<BookRequestModel> getBooks(int page, int size);

}
