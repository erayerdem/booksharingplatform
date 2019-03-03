package book.bookplatform.user.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSignUpRequestModel {


    @Size(min = 3, max = 35, message = "Lütfen Uygun Bir İsim Giriniz! ")
    @Pattern(regexp = "^(([A-za-z ğüşöçİĞÜŞÖÇ]+[\\s]{1}[A-za-z ğüşöçİĞÜŞÖÇ]+)|([A-Za-z]+))$", message = "Lütfen Uygun Bir İsim Giriniz")
    @NotNull
    private String name;

    @Size(min = 3, max = 25)
    @Pattern(regexp = "^[A-z ğüşöçİĞÜŞÖÇ](?!\\s)[a-z ğüşöçİĞÜŞÖÇ]*((\\W)?[A-Z İĞÜŞÖÇ][a-z ğüşöç]+)*$")
    @NotNull
    private String surname;

    @Email(message = "geçerli bir e-mail adresi giriniz")
    @NotNull
    private String email;

    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z ğüşöç])(?=.*[A-Z İĞÜŞÖ])(?=.*[a-zA-Z ğüşöçİĞÜŞÖ]).{8,}$", message = "Paralonız en az bir rakam ve özel karakter içermelidir ")
    @NotNull
    private String password;

    @NotNull
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z ğüşöç])(?=.*[A-Z İĞÜŞÖ])(?=.*[a-zA-Z ğüşöçİĞÜŞÖ]).{8,}$", message = "Paralonız en az bir rakam ve özel karakter içermelidir ")
    private String confirmpassword;

    public static void main(String[] args) {

    }


}
