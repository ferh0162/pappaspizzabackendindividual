package dat22v2.tb.pappaspizza.service;

import dat22v2.tb.pappaspizza.dto.ingredient.IngredientRequest;
import dat22v2.tb.pappaspizza.dto.ingredient.IngredientResponse;
import dat22v2.tb.pappaspizza.dto.user.UserRequest;
import dat22v2.tb.pappaspizza.dto.user.UserResponse;
import dat22v2.tb.pappaspizza.dto.user.address.AddressRequest;
import dat22v2.tb.pappaspizza.entity.user.Address;
import dat22v2.tb.pappaspizza.entity.user.User;
import dat22v2.tb.pappaspizza.exception.EmailAlreadyExistsException;
import dat22v2.tb.pappaspizza.exception.IlegalIngredientException;
import dat22v2.tb.pappaspizza.repository.UserRepository;
import dat22v2.tb.security.entity.Role;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EntityManager entityManager;

    UserService userService;

    Boolean readyData = false;
    int listSize = 3;

    private User user1;
    private User user2;
    private User user3;
    @BeforeEach
    void setUp(){

        userService = new UserService(userRepository);
        if (!readyData){

            user1 = new User();
            user1.setFirstName("Tester1");
            user1.setLastName("test1");
            user1.setAddress(new Address());
            user1.setPhone("91826545");
            user1.setEmail("Testmail1");
            user1.setUsername("TesterUser1");
            user1.setPassword("TestWord");
            user1.addRole(Role.ADMIN);

            user2 = new User();
            user2.setFirstName("Tester2");
            user2.setLastName("test2");
            user2.setAddress(new Address());
            user2.setPhone("91826545");
            user2.setEmail("Testmail2");
            user2.setUsername("TesterUser2");
            user2.setPassword("TestWord");
            user2.addRole(Role.ADMIN);

            user3 = new User();
            user3.setFirstName("Tester3");
            user3.setLastName("test3");
            user3.setAddress(new Address());
            user3.setPhone("91826545");
            user3.setEmail("Testmail3");
            user3.setUsername("TesterUser3");
            user3.setPassword("TestWord");
            user3.addRole(Role.ADMIN);





            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);


        }
        for (UserResponse response : userService.getUsers()) {
            System.out.println(response.getUsername());
        }



    }
    @Test
    void getUsers() {
        List<UserResponse> users = userService.getUsers();

        assertEquals(listSize, users.size());
    }

    @Test
    void addUser() throws EmailAlreadyExistsException {
        UserRequest newUser = new UserRequest();
        newUser.setFirstName("Tester4");
        newUser.setLastName("test4");
        newUser.setAddress(new AddressRequest());
        newUser.setEmail("Testmail4");
        newUser.setUsername("TesterUser4");
        newUser.setPassword("TestWord");

        UserResponse response = userService.addUser(newUser);
        assertEquals(newUser.getFirstName(), response.getFirstName());
        assertEquals(newUser.getLastName(), response.getLastName());
        assertEquals(newUser.getEmail(), response.getEmail());
        assertEquals(newUser.getUsername(), response.getUsername());
    }

    @Test
    void addUserFail() throws EmailAlreadyExistsException {
        UserRequest newUser = new UserRequest();
        newUser.setFirstName("Tester4");
        newUser.setLastName("test4");
        newUser.setAddress(new AddressRequest());
        //notice mail is set to same as user1 for duplicate email to trigger error
        newUser.setEmail("Testmail1");
        newUser.setUsername("TesterUser4");
        newUser.setPassword("TestWord");
        assertThrows(EmailAlreadyExistsException.class, () -> {
            userService.addUser(newUser);
        });
    }

}