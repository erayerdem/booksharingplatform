package book.bookplatform.user.model;


import book.bookplatform.book.model.BookDatabaseModel;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
@Entity
@Data
@Table(name = "User")
public class UserDatabaseModel implements Serializable, UserDetails {


    @Id
    @GeneratedValue
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
    @OneToMany(mappedBy = "userDatabaseModel")
    private Set<BookDatabaseModel> bookDatabaseModelSet =new HashSet<>();
    private boolean isenabled = true;
    private boolean isCredentialsNonExpired = true;
    private boolean isAccountNonLocked = true;
    private boolean isAccountNonExpired = true;
    @ManyToMany(fetch = FetchType.EAGER)

    private  Set<Role> roles;
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


}
