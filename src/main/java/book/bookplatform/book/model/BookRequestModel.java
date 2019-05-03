package book.bookplatform.book.model;

import lombok.Data;

@Data
public class BookRequestModel {
    private Long id;
    private String bookname;
    private String author;
    private Integer page;
    private String coverphoto;
    private String summary;
}
