package book.bookplatform.user.repository;

import book.bookplatform.book.model.BookDatabaseModel;
import book.bookplatform.user.model.UserDatabaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserDatabaseModel, Long> {

    boolean existsByEmail(@Param("email") String email);

   Optional<UserDatabaseModel> findByEmail(@Param("email") String email);

   List<BookDatabaseModel> findBookDatabaseModelsByEmail(@Param("email") String email);
}
