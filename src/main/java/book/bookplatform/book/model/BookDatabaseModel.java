package book.bookplatform.book.model;

import book.bookplatform.user.model.UserDatabaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "book")
@Data
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor
public class BookDatabaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookname;
    private String author;
    private Integer page;
    private byte [] coverphoto;
    private String summary;
    @ManyToOne(fetch = FetchType.EAGER)
    private UserDatabaseModel userDatabaseModel;
}
