package dat22v2.tb.pappaspizza.repository;


import dat22v2.tb.pappaspizza.entity.user.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    Address findById(int id);

}
