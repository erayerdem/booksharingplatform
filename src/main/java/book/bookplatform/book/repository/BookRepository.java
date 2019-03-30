package book.bookplatform.book.repository;

import book.bookplatform.book.model.BookDatabaseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookDatabaseModel, Long> {



}
