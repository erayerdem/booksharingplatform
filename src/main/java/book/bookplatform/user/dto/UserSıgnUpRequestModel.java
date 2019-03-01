package book.bookplatform.user.dto;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
public class UserSıgnUpRequestModel {

    @NotNull
    @Size(min = 3,max = 35,message = "Lütfen Uygun Bir İsim Giriniz! ")
    @Pattern(regexp = "([A-Z a-z])\\w",message = "Lütfen Uygun Bir İsim Giriniz")
    private String name;
    @NotNull
    @Size(min = 3,max = 25)
    private String surname;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String confirmpassword;


}
