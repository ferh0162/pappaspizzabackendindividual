package dat22v2.tb.pappaspizza.repository;

import dat22v2.tb.pappaspizza.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import java.util.List;


@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Integer>, JpaSpecificationExecutor<Ingredient> {

  Ingredient findIngredientByNameIgnoreCase(String name);

  Optional<Ingredient> findById(Integer integer);

  List<Ingredient> findByIdIn(List<Integer> ids);

  List<Ingredient> findByNameIn(List<String> ingredientNames);


}
