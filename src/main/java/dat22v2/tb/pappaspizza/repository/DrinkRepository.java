package dat22v2.tb.pappaspizza.repository;

import dat22v2.tb.pappaspizza.entity.Drink;
import dat22v2.tb.pappaspizza.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends JpaRepository<Drink,Integer>, JpaSpecificationExecutor<Drink>{

  Drink findDrinkById(int id);
  Drink findDrinkByBrandAndDrinkSize(String brand, String drinkSize);

  Drink findDrinkByBrand_BrandAndDrinkSize_Size(String brand, String drinkSize);
}
