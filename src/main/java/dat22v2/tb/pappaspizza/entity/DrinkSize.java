package dat22v2.tb.pappaspizza.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity

public class DrinkSize {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(unique = true)
    String size;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "drinkSize")
    List<Drink> drinks;

    public DrinkSize(String size) {
        this.size = size;
    }

    public void addDrink(Drink drink) {
        if (drinks == null) {
            drinks = new ArrayList<>();
        }
        drinks.add(drink);
        drink.setDrinkSize(this);



    }
}
