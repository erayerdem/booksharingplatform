package book.bookplatform.user.model;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "User" )
public class UserDatabaseModel  implements Serializable {


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

}
