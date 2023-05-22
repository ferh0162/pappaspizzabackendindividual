package dat22v2.tb.pappaspizza.api;

import dat22v2.tb.pappaspizza.dto.user.UserRequest;
import dat22v2.tb.pappaspizza.dto.user.UserResponse;
import dat22v2.tb.pappaspizza.exception.EmailAlreadyExistsException;
import dat22v2.tb.pappaspizza.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/users")
public class UserController {

        UserService userService;

        public UserController(UserService userService) {
            this.userService = userService;
        }

        //Kind of useless
        @PreAuthorize("hasAuthority('ADMIN')")
        @GetMapping
        List<UserResponse> getUsers() {
            return userService.getUsers();
        }

        @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        UserResponse addUser(@RequestBody UserRequest userRequest) throws EmailAlreadyExistsException {
            return userService.addUser(userRequest);
        }


}
