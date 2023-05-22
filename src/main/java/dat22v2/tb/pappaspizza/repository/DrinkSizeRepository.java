package dat22v2.tb.pappaspizza.repository;

import dat22v2.tb.pappaspizza.entity.Brand;
import dat22v2.tb.pappaspizza.entity.DrinkSize;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkSizeRepository extends JpaRepository<DrinkSize, Integer> {
}
