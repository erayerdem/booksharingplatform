package book.bookplatform.user.model;


import book.bookplatform.book.model.BookDatabaseModel;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

@Entity(name = "userdatabasemodel")
@Data
@Table(name = "Users")
@ToString
public class UserDatabaseModel implements Serializable, UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private UUID userid = UUID.randomUUID();
    private String name;
    private String surname;
    @Column(unique = true, nullable = false)
    private String email;
    private String encryptedpassword;
    @CreationTimestamp
    private LocalDateTime localDateTime;
    @OneToMany(mappedBy = "userDatabaseModel", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<BookDatabaseModel> books = new ArrayList<>();
    private boolean isenabled = true;
    private boolean isCredentialsNonExpired = true;
    private boolean isAccountNonLocked = true;
    private boolean isAccountNonExpired = true;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return encryptedpassword;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isenabled;
    }

    public void setRole(Role role) {
        roles.add(role);
    }


}
