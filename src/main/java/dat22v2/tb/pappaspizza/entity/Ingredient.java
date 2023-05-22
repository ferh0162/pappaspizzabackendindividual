package dat22v2.tb.pappaspizza.entity;

import dat22v2.tb.pappaspizza.dto.ingredient.IngredientRequest;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Double price;

    public Ingredient(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
