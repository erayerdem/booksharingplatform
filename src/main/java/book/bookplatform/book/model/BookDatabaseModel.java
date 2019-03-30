package book.bookplatform.book.model;

import book.bookplatform.user.model.UserDatabaseModel;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "book")
public class BookDatabaseModel {
    @Id
    private Long id;
    private String bookname;
    private String author;
    private short page;
    private String coverphoto;
    private String summary;
    @ManyToOne(fetch = FetchType.LAZY)
    private UserDatabaseModel userDatabaseModel;
}
