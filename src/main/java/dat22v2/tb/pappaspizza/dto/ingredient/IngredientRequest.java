package dat22v2.tb.pappaspizza.dto.ingredient;

import dat22v2.tb.pappaspizza.entity.Ingredient;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IngredientRequest {

    private Integer id;
    private String name;

    private double price;

    public IngredientRequest(String name, double price){
        this.name = name;
        this.price = price;

    }

    public Ingredient getIngredientEntity(){
        return new Ingredient(
                this.getName(),
                this.getPrice()
        );
    }




}
