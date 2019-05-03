package book.bookplatform.book.repository;

import book.bookplatform.book.model.BookDatabaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BookRepository extends PagingAndSortingRepository<BookDatabaseModel, Long> {



}
