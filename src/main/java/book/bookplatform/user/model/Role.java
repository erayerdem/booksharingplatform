package book.bookplatform.user.model;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {
    private RoleName roleName;

    @Override
    public String getAuthority() {
        return this.roleName.name();
    }
}

enum RoleName {

    ADMIN, USER

}