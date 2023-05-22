package dat22v2.tb.pappaspizza.dto.pizza;

import lombok.*;

import java.util.List;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MakePizzaRequest {

    private String name;
    private double price;
    private List<String> ingredients;








}
