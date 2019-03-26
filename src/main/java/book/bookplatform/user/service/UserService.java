package book.bookplatform.user.service;


import book.bookplatform.user.model.UserDatabaseModel;
import book.bookplatform.user.model.UserSignUpRequestModel;
import book.bookplatform.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder bcyrptPasswordencoder;

    public void createUser(UserSignUpRequestModel userSignUpRequestModel) {
        UserDatabaseModel userDatabaseModel = new UserDatabaseModel();
        BeanUtils.copyProperties(userSignUpRequestModel, userDatabaseModel);
        userDatabaseModel.setEncryptedpassword(bcyrptPasswordencoder.encode(userSignUpRequestModel.getPassword()));
        UserDatabaseModel save = userRepository.save(userDatabaseModel);
    }
}
