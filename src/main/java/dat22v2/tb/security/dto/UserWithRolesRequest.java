package dat22v2.tb.security.dto;



import lombok.Data;
import lombok.NonNull;

@Data
public class UserWithRolesRequest {
    @NonNull
    String username;
    @NonNull
    String password;
    @NonNull
    String email;
}