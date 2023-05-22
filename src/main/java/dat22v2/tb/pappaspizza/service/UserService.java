package dat22v2.tb.pappaspizza.service;

import dat22v2.tb.pappaspizza.dto.user.UserRequest;
import dat22v2.tb.pappaspizza.dto.user.UserResponse;
import dat22v2.tb.pappaspizza.entity.user.User;
import dat22v2.tb.pappaspizza.exception.EmailAlreadyExistsException;
import dat22v2.tb.pappaspizza.repository.UserRepository;
import dat22v2.tb.security.entity.Role;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream().map(UserResponse::new).toList();
    }


    public UserResponse addUser(UserRequest body) throws EmailAlreadyExistsException {

        if(userRepository.existsByEmail(body.getEmail())) {
            throw new EmailAlreadyExistsException("Email already taken by different entry.");
        }

        User user = UserRequest.getUserEntity(body);
        user.addRole(Role.USER);
        userRepository.save(user);
        return new UserResponse(user);
    }


}
