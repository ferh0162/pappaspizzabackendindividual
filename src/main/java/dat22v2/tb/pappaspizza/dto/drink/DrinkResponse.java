package dat22v2.tb.pappaspizza.dto.drink;

import dat22v2.tb.pappaspizza.entity.Drink;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DrinkResponse {

    Integer id;

    String brand;

    String size;

    Double price;

    public DrinkResponse(Drink drink) {
        this.id = drink.getId();
        this.brand = drink.getBrand().getBrand();
        this.size = drink.getDrinkSize().getSize();
        this.price = drink.getPrice();
    }
}
