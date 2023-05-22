package dat22v2.tb.pappaspizza.repository;

import dat22v2.tb.pappaspizza.entity.PizzaType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaTypeRepository extends JpaRepository<PizzaType, Integer> {

  PizzaType findPizzaTypeBySize(String size);

}
