package book.bookplatform.user.service;

import book.bookplatform.user.model.UserSignUpRequestModel;

public interface UserService {

    public void createUser(UserSignUpRequestModel userSignUpRequestModel);
}
