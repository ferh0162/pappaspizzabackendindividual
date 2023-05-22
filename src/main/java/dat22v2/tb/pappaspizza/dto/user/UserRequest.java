package dat22v2.tb.pappaspizza.dto.user;

import dat22v2.tb.pappaspizza.dto.user.address.AddressRequest;
import dat22v2.tb.pappaspizza.entity.user.Address;
import dat22v2.tb.pappaspizza.entity.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
public class UserRequest {
    String firstName;
    String lastName;
    AddressRequest address;
    String phoneNumber;
    String email;
    String username;
    String password;


    public static User getUserEntity(UserRequest body) {
        User user = User.builder()
                .address(AddressRequest.getAddressEntity(body.getAddress()))
                .firstName(body.getFirstName())
                .lastName(body.getLastName())
                .phone(body.getPhoneNumber())
                .build();
        user.setPassword(body.getPassword());
        user.setUsername(body.getUsername());
        user.setEmail(body.getEmail());
        return user;

    }



}
