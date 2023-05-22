package dat22v2.tb.pappaspizza.service;

import dat22v2.tb.pappaspizza.dto.ingredient.IngredientRequest;
import dat22v2.tb.pappaspizza.dto.ingredient.IngredientResponse;
import dat22v2.tb.pappaspizza.entity.Ingredient;
import dat22v2.tb.pappaspizza.exception.IlegalIngredientException;
import dat22v2.tb.pappaspizza.repository.IngredientRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class IngredientServiceTest {

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    EntityManager entityManager;

    IngredientService ingredientService;

    Boolean readyData = false;
    int listSize = 3;

    private Ingredient ingredient1;
    private Ingredient ingredient2;
    private Ingredient ingredient3;

    @BeforeEach
    void setUp(){

        ingredientService = new IngredientService(ingredientRepository);
        if (!readyData){
            ingredient1 = Ingredient.builder()
                    .name("tomato")
                    .price(25.0)
                    .build();
            ingredient2 = Ingredient.builder()
                    .name("cheese")
                    .price(50.0)
                    .build();
            ingredient3 = Ingredient.builder()
                    .name("sausage")
                    .price(60.5)
                    .build();
            ingredientRepository.save(ingredient1);
            ingredientRepository.save(ingredient2);
            ingredientRepository.save(ingredient3);

        }
        for (IngredientResponse response : ingredientService.getAllIngredients()) {
            System.out.println(response.getId());
        }



    }

    @Test
    void getAllIngredients() {
        List<IngredientResponse> ingredients = ingredientService.getAllIngredients();

        assertEquals(listSize, ingredients.size());
    }

    @Test
    void getSpecificIngredient() {
        entityManager.createNativeQuery("ALTER TABLE ingredient ALTER COLUMN id RESTART WITH 1")
                .executeUpdate();
        Ingredient ingredient = Ingredient.builder()
                .name("test")
                .price(11.1)
                .build();
        ingredientRepository.save(ingredient);
        IngredientResponse getIngredient = ingredientService.getSpecificIngredient(1);

        assertEquals(getIngredient.getId(), ingredient.getId());
        assertEquals(getIngredient.getName(), ingredient.getName());
        assertEquals(getIngredient.getPrice(), ingredient.getPrice());


    }

    @Test
    void addIngredient() throws IlegalIngredientException {
        IngredientRequest newIngredient = IngredientRequest.builder()
                .name("bob")
                .price(66.6)
                .build();
        IngredientResponse response = ingredientService.addIngredient(newIngredient);
        assertTrue(response.getId() > 0);
        assertEquals(newIngredient.getName(), response.getName());
        assertEquals(newIngredient.getPrice(), response.getPrice());
    }
    @Test
    void addIngredientFail() throws IlegalIngredientException {
        IngredientRequest newIngredient = IngredientRequest.builder()
                .name("b")
                .price(66.6)
                .build();
        assertThrows(IlegalIngredientException.class, () -> {
            ingredientService.addIngredient(newIngredient);
        });
    }


    @Test
    void editIngredient() {
        IngredientRequest changedIngredient = IngredientRequest.builder()
                .name("bob")
                .price(66.6)
                .build();
        ingredientService.editIngredient(ingredient1.getId(), changedIngredient);

        assertEquals(ingredient1.getName(), changedIngredient.getName());
        assertEquals(ingredient1.getPrice(), changedIngredient.getPrice());
    }

    @Test
    void deleteIngredient() {
        System.out.println(ingredient1.getId() + "Delete Test");

        ingredientService.deleteIngredient(ingredient1.getId());

        assertFalse(ingredientRepository.existsById(ingredient1.getId()));
    }
}