package dat22v2.tb.pappaspizza.repository;

import dat22v2.tb.pappaspizza.entity.user.Address;
import dat22v2.tb.pappaspizza.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);
}
