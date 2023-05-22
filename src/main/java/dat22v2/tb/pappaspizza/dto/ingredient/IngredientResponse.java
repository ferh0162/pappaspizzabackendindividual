package dat22v2.tb.pappaspizza.dto.ingredient;

import dat22v2.tb.pappaspizza.entity.Ingredient;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IngredientResponse {

    private Integer id;

    private String name;

    private double price;

    public IngredientResponse(Ingredient ingredient) {
        this.id = ingredient.getId();
        this.name = ingredient.getName();
        this.price = ingredient.getPrice();

    }
}
