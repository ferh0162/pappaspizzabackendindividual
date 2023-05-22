package dat22v2.tb.pappaspizza.service;

import dat22v2.tb.pappaspizza.dto.pizza.MakePizzaRequest;
import dat22v2.tb.pappaspizza.dto.pizza.PizzaResponse;
import dat22v2.tb.pappaspizza.entity.Pizza;
import dat22v2.tb.pappaspizza.repository.IngredientRepository;
import dat22v2.tb.pappaspizza.repository.PizzaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PizzaService {

    PizzaRepository pizzaRepository;

    IngredientRepository ingredientRepository;

    public PizzaService(PizzaRepository pizzaRepository, IngredientRepository ingredientRepository) {
        this.pizzaRepository = pizzaRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public List<PizzaResponse> getAllPizzas() {
        List<Pizza> pizzas = pizzaRepository.findAll();
        List<PizzaResponse> pizzaResponses = new ArrayList<>();
        pizzaResponses = pizzas.stream().map(pizza -> new PizzaResponse(pizza)).toList();
        System.out.println(pizzaResponses);
        return pizzaResponses;
    }

    public List<PizzaResponse> getPizzas(){
        return pizzaRepository.findAll().stream().map(PizzaResponse::new).toList();
    }

    public PizzaResponse addPizza(MakePizzaRequest pizzaRequest) {
        Pizza pizza = new Pizza();
        pizza.setName(pizzaRequest.getName());
        pizza.setPrice(pizzaRequest.getPrice());

        pizza.setIngredients(ingredientRepository.findByNameIn(pizzaRequest.getIngredients()));

        return new PizzaResponse(pizzaRepository.save(pizza));
    }

    public PizzaResponse changePizzaPrice(int id, Double price) {
        Pizza pizza = pizzaRepository.findById(id);
        pizza.setPrice(price);
        return new PizzaResponse(pizzaRepository.save(pizza));
    }
}
