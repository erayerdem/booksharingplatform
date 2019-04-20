package book.bookplatform.user.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSignUpRequestModel implements Serializable {


    @Size(min = 3, max = 35, message = "Lütfen Uygun Bir İsim Giriniz!")
    @Pattern(regexp = "^(([A-za-z ğüşöçİĞÜŞÖÇ]+[\\s]{1}[A-za-z ğüşöçİĞÜŞÖÇ]+)|([A-Za-z]+))$", message = "Lütfen Uygun Bir İsim Giriniz")
    @NotNull(message = "isim null olamaz")
    private String name;

    @Size(min = 3, max = 25)
    @Pattern(regexp = "^[A-z ğüşöçİĞÜŞÖÇ](?!\\s)[a-z ğüşöçİĞÜŞÖÇ]*((\\W)?[A-Z İĞÜŞÖÇ][a-z ğüşöç]+)*$", message = "Uygun bir soyad giriniz")
    @NotNull(message = "soyad null olamaz")
    private String surname;

    @Email(message = "geçerli bir e-mail adresi giriniz")
    @NotNull(message = "e mail null olamaz")
    private String email;

    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$", message = "Paralonız en az bir rakam  büyük harf ve özel karakter içermelidir")
    @NotNull(message = "parala null olamaz")
    private String password;

    @NotNull(message = "parola doğrulama null olamaz")
    private String confirmpassword;


}
