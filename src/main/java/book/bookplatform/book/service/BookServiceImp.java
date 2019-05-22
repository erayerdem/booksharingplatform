package book.bookplatform.book.service;


import book.bookplatform.book.model.BookCreatingModel;
import book.bookplatform.book.model.BookDatabaseModel;
import book.bookplatform.book.model.BookRequestModel;
import book.bookplatform.book.repository.BookRepository;
import book.bookplatform.user.model.UserDatabaseModel;
import book.bookplatform.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookServiceImp implements BookService {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Transactional
    public void createBook(BookCreatingModel book) {

        BookDatabaseModel bookDatabaseModel = new BookDatabaseModel();
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        BeanUtils.copyProperties(book, bookDatabaseModel);
        bookDatabaseModel.setCoverphoto(book.getCoverphoto().getBytes());
        Optional<UserDatabaseModel> user = userRepository.findByEmail(email);
        user.ifPresent(userDatabaseModel -> {

            userDatabaseModel.setBooks(Arrays.asList(bookDatabaseModel));
            bookDatabaseModel.setUserDatabaseModel(userDatabaseModel);

        });


    }

    @Override
    public List<BookRequestModel> getBooks(int page, int size) {
        System.out.println("hello world");
        final List<BookRequestModel> bookRequestModels = new ArrayList<>();
        PageRequest of = PageRequest.of(page, size, Sort.by("bookname"));
        Page<BookDatabaseModel> all = bookRepository.findAll(of);
        all.forEach(bookDatabaseModel -> {
            BookRequestModel bookRequestModel = new BookRequestModel();
            BeanUtils.copyProperties(bookDatabaseModel, bookRequestModel);
            bookRequestModel.setCoverphoto(String.valueOf(new String(bookDatabaseModel.getCoverphoto())));
            bookRequestModels.add(bookRequestModel);

        });
        return bookRequestModels;
    }
}
