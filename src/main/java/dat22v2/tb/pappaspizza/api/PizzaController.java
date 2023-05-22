package dat22v2.tb.pappaspizza.api;


import dat22v2.tb.pappaspizza.dto.pizza.MakePizzaRequest;
import dat22v2.tb.pappaspizza.dto.pizza.PizzaRequest;
import dat22v2.tb.pappaspizza.dto.pizza.PizzaResponse;
import dat22v2.tb.pappaspizza.service.PizzaService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/pizzas")
@CrossOrigin
public class PizzaController {


    PizzaService pizzaService;


    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public ResponseEntity<List<PizzaResponse>> getAllPizzas() {
        return ResponseEntity.ok(pizzaService.getAllPizzas());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<PizzaResponse> addPizza(@RequestBody MakePizzaRequest pizzaRequest) {
        return ResponseEntity.ok(pizzaService.addPizza(pizzaRequest));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping("/{id}/price/{price}")
    public ResponseEntity<PizzaResponse> changePizzaPrice(@PathVariable("price") Double price, @PathVariable("id") int id) {
        return ResponseEntity.ok(pizzaService.changePizzaPrice(id, price));
    }


}
