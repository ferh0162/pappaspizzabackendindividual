package dat22v2.tb.pappaspizza.entity;
import dat22v2.tb.pappaspizza.dto.pizza.PizzaRequest;
import jakarta.persistence.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "pizza")
@DiscriminatorColumn(name = "consumable_type")
public class Pizza extends Consumable{

    private String name;

    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Ingredient> ingredients;

    public void addIngredient(Ingredient ingredient){
        if (ingredients == null) {
            ingredients = new ArrayList<>();
        }
        this.ingredients.add(ingredient);
    }


    public Pizza(int id, String name,double price, List<Ingredient> ingredients) {
        super.setId(id);
        super.setPrice(price);
        this.name = name;
        this.ingredients = ingredients;
    }


}
