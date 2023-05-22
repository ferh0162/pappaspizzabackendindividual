package dat22v2.tb.pappaspizza.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @JsonIgnore
    @ManyToOne
    Order order;

    @ManyToOne
    Consumable consumable;

    Integer quantity;

    @ManyToMany
    List<Ingredient> added;
    @ManyToMany
    List<Ingredient> removed;
    @ManyToOne
    PizzaType pizzaType;

    public void setPizzaType(PizzaType pizzaType) {
        this.pizzaType = pizzaType;
        pizzaType.addOrderItem(this);
    }

    public OrderItem(Order order, Consumable consumable, Integer quantity, List<Ingredient> added, List<Ingredient> removed) {
        this.order = order;
        this.consumable = consumable;
        this.quantity = quantity;
        this.added = added;
        this.removed = removed;
    }
}
