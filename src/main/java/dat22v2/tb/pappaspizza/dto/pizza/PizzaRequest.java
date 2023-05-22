package dat22v2.tb.pappaspizza.dto.pizza;


import dat22v2.tb.pappaspizza.dto.ingredient.IngredientRequest;
import dat22v2.tb.pappaspizza.entity.Ingredient;
import dat22v2.tb.pappaspizza.entity.Pizza;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PizzaRequest {

    private String name;
    private double price;
    private List<IngredientRequest> ingredients;



    public static Pizza getPizzaEntity(PizzaRequest pizzaRequest) {
        Pizza pizza = new Pizza();
        pizza.setName(pizzaRequest.getName());
        pizza.setPrice(pizzaRequest.getPrice());
        pizza.setIngredients(pizzaRequest.getIngredients().stream().map(IngredientRequest::getIngredientEntity).toList());
        return pizza;
    }


}
