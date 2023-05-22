package dat22v2.tb.pappaspizza.entity;


import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Consumable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double price;

}
