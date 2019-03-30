package book.bookplatform.configuration;

import book.bookplatform.user.model.UserDatabaseModel;
import book.bookplatform.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class UserDetailServiceImp implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserDatabaseModel> userOptional = userRepository.findByEmail(email);
        return userOptional.orElseThrow(() -> new UsernameNotFoundException("user not found by '" + email));

    }
}
