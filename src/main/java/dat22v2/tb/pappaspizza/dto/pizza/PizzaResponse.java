package dat22v2.tb.pappaspizza.dto.pizza;

import dat22v2.tb.pappaspizza.dto.ingredient.IngredientResponse;
import dat22v2.tb.pappaspizza.entity.Pizza;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PizzaResponse {

    private Integer id;

    private String name;

    private double price;

    private List<IngredientResponse> ingredients;


    public PizzaResponse(Pizza pizza) {
        this.id = pizza.getId();
        this.name = pizza.getName();
        this.price = pizza.getPrice();
        this.ingredients = pizza.getIngredients().stream().map(IngredientResponse::new).collect(Collectors.toList());

    }
}
