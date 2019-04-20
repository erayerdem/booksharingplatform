package book.bookplatform;

import book.bookplatform.user.model.UserLoginRequestModel;
import book.bookplatform.user.model.UserSignUpRequestModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class User {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("Succes Authanticate Bro")
    public void succesauthanticatice() throws Exception {
        UserLoginRequestModel userLoginRequestModel = new UserLoginRequestModel();
        userLoginRequestModel.setUsername("sameterayerdm@gmail.com");
        userLoginRequestModel.setPassword("samet");

        String usernameandpasssword = objectMapper.writeValueAsString(userLoginRequestModel);

        MvcResult authorization = mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(usernameandpasssword)).andExpect(status().is2xxSuccessful())
                .andExpect(header().exists("Authorization")).andReturn();


    }

    @Test
    @DisplayName("No Gate !!!")
    public void noGate() throws Exception {
        UserLoginRequestModel userLoginRequestModel = new UserLoginRequestModel();
        userLoginRequestModel.setUsername("helloworlg@gmail.com");
        userLoginRequestModel.setPassword("123456");
        String usernameandpasssword = objectMapper.writeValueAsString(userLoginRequestModel);
        mockMvc.perform(post("/login").contentType(MediaType.APPLICATION_JSON)
                .content(usernameandpasssword))
                .andExpect(status().is(401))
                .andExpect(header().doesNotExist("Authorization"));
    }

    @Test
    @DisplayName("succes sign up")
    public void succesSignUp() throws Exception {
        UserSignUpRequestModel userSignUpRequestModel = new UserSignUpRequestModel();
        userSignUpRequestModel.setName("samet");
        userSignUpRequestModel.setSurname("eray");
        userSignUpRequestModel.setPassword("Stevie?1");
        userSignUpRequestModel.setConfirmpassword("Stevie?1");
        userSignUpRequestModel.setEmail("sameterayerdm@samet.com");
        String signup = objectMapper.writeValueAsString(userSignUpRequestModel);
        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(signup))
                .andExpect(status().isCreated())
                .andExpect(header().doesNotExist("Authorization"));
    }


    @Test
    @DisplayName("İsim Validation")
    public void unsuccesSignUp() throws Exception {
        // isim rakam felan içeremez
        UserSignUpRequestModel userSignUpRequestModel = new UserSignUpRequestModel();
        userSignUpRequestModel.setName("samet1");
        userSignUpRequestModel.setSurname("eray");
        userSignUpRequestModel.setPassword("Stevie?1");
        userSignUpRequestModel.setConfirmpassword("Stevie?1");
        userSignUpRequestModel.setEmail("sameterayerdm@samet.com");
        String signup = objectMapper.writeValueAsString(userSignUpRequestModel);
        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(signup))
                .andExpect(status().isBadRequest())
                .andExpect(header().doesNotExist("Authorization"))
                .andExpect(jsonPath("message").value("Lütfen Uygun Bir İsim Giriniz"))
                .andExpect(jsonPath("statuscode").value(400));


    }

    @Test
    @DisplayName("Parola Özel Karakter Rakam vs .")
    public void parolaValidation() throws Exception {
        UserSignUpRequestModel userSignUpRequestModel = new UserSignUpRequestModel();
        userSignUpRequestModel.setSurname("eray");
        userSignUpRequestModel.setConfirmpassword("Stevie?1");
        userSignUpRequestModel.setEmail("sameterayerdm@samet.com");
        userSignUpRequestModel.setPassword("Stevie1");
        userSignUpRequestModel.setName("samet");
        final String signupsecond = objectMapper.writeValueAsString(userSignUpRequestModel);
        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(signupsecond))
                .andExpect(status().isBadRequest())
                .andExpect(header().doesNotExist("Authorization"))
                .andExpect(jsonPath("message").value("Paralonız en az bir rakam  büyük harf ve özel karakter içermelidir"))
                .andExpect(jsonPath("statuscode").value(400));
    }
    @Test
    @DisplayName("Parolalar eşleşmeli")
    public  void passwordMatch() throws Exception {
        UserSignUpRequestModel userSignUpRequestModel = new UserSignUpRequestModel();
        userSignUpRequestModel.setSurname("eray");
        userSignUpRequestModel.setName("samet");
        userSignUpRequestModel.setConfirmpassword("Stevie?1");
        userSignUpRequestModel.setEmail("sameterayerdm@samet.com");
        userSignUpRequestModel.setPassword("Stevie1#");
        String signup = objectMapper.writeValueAsString(userSignUpRequestModel);
        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(signup))
                .andExpect(status().isBadRequest())
                .andExpect(header().doesNotExist("Authorization"))
                .andExpect(jsonPath("message").value("Parolalar Aynı Olmalı"))
                .andExpect(jsonPath("statuscode").value(400));
    }
}
