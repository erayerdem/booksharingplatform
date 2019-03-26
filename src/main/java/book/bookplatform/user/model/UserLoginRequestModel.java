package book.bookplatform.user.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserLoginRequestModel implements Serializable {
    private String email;
    private String password;

}
