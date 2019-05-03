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
public class BookCreatingModel implements Serializable {
    @NotNull
    @Size(min = 5, max = 40)
    private String bookname;
    @NotNull
    @Size(min = 5, max = 30)
    private String author;
    @NotNull
    private Integer page;
    @NotNull
    private String coverphoto;
    @NotNull
    @Size(min = 20)
    private String summary;

}
