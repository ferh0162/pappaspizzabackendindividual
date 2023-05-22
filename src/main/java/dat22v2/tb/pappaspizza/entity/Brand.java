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
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brand")
    private List<Drink> drinks;


    @Column(unique = true)
    private String brand;


    public Brand(String brand) {
        this.brand = brand;
    }

    public void addDrink(Drink drink) {
        if (drinks == null) {
            drinks = new ArrayList<>();
        }
        drinks.add(drink);
        drink.setBrand(this);



    }
}
