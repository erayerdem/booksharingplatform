package book.bookplatform.book.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {
    @NotNull
    @Size(min = 5, max = 40)
    private String bookname;
    @NotNull
    @Size(min = 5, max = 30)
    private String author;
    @NotNull
    @Size(min = 50, max = 2000)
    private short page;
    @NotNull
    private String coverphoto;
    @NotNull
    @Size(min = 20)
    private String summary;

}
