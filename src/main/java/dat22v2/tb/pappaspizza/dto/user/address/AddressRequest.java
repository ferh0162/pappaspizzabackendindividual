package dat22v2.tb.pappaspizza.dto.user.address;

import dat22v2.tb.pappaspizza.entity.user.Address;
import dat22v2.tb.pappaspizza.entity.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AddressRequest {

    private String street;
    private String zip;
    private String city;

    public static Address getAddressEntity(AddressRequest addressRequest){
        Address address = Address.builder()
                .street(addressRequest.getStreet())
                .zip(addressRequest.getZip())
                .city(addressRequest.getCity())
                .build();
        return address;
    }

}
