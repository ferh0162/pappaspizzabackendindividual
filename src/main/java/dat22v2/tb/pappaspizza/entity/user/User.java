package dat22v2.tb.pappaspizza.entity.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import dat22v2.tb.security.entity.UserWithRoles;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "USER_TYPE")
@Entity
public class User extends UserWithRoles {

    private String phone;
    private String firstName;
    private String lastName;

    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @CreationTimestamp
    private LocalDateTime creationDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @UpdateTimestamp
    private LocalDateTime lastEdited;



}
