package dat22v2.tb.pappaspizza.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;

import dat22v2.tb.pappaspizza.dto.user.address.AddressRequest;
import dat22v2.tb.pappaspizza.entity.user.Address;
import dat22v2.tb.pappaspizza.entity.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {


    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Address address;
    private LocalDateTime created;
    private LocalDateTime lastEdited;

    public UserResponse(User user) {
        this.address = user.getAddress();
        this.username = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
    }

}