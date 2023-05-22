package dat22v2.tb.pappaspizza.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.engine.jdbc.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@DiscriminatorColumn(name = "consumable_type")
public class Drink extends Consumable{


    @ManyToOne(cascade = CascadeType.MERGE)
    private Brand brand;

    @ManyToOne(cascade = CascadeType.MERGE)
    private DrinkSize drinkSize;


    public Drink(Brand brand, DrinkSize size, Double price) {
        this.setPrice(price);

        brand.addDrink(this);
        size.addDrink(this);


    }

}
