package dat22v2.tb.pappaspizza.service;

import dat22v2.tb.pappaspizza.dto.ingredient.IngredientRequest;
import dat22v2.tb.pappaspizza.dto.ingredient.IngredientResponse;
import dat22v2.tb.pappaspizza.entity.Ingredient;
import dat22v2.tb.pappaspizza.exception.IlegalIngredientException;
import dat22v2.tb.pappaspizza.repository.IngredientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }


    public List<IngredientResponse> getAllIngredients() {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        List<IngredientResponse> ingredientResponses;
        ingredientResponses = ingredients.stream().map(ingredient -> new IngredientResponse(ingredient)).toList();
        return ingredientResponses;
    }



    public IngredientResponse getSpecificIngredient(Integer id) {
        Ingredient ingredient = ingredientRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Ingrediens findes ikke"));
        return new IngredientResponse(ingredient);
    }

    public IngredientResponse addIngredient(IngredientRequest body) throws IlegalIngredientException {
        String danishAlphabet = "abcdefghijklmnopqrstuvwxyzæøå";
        boolean check1 = true;
        Ingredient ingredient = body.getIngredientEntity();
        for (int i = 0; i< body.getName().length(); i++){
            char currentChar = body.getName().charAt(i);
            if (!danishAlphabet.contains(String.valueOf(currentChar))){
                check1 = false;
            }
        }
        if (check1 && 2 <= body.getName().length() ){

            ingredientRepository.save(ingredient);
        } else {
           throw new  IlegalIngredientException("Du har tastet forkert");
        }

        return new IngredientResponse(ingredient);

    }

    public ResponseEntity<Boolean> editIngredient(Integer id, IngredientRequest body) {
        Ingredient ingredient = ingredientRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Ingrediens findes ikke"));
        if (body.getName() != null){
            ingredient.setName(body.getName());
        }
        if (body.getPrice() != 0){
            ingredient.setPrice(body.getPrice());
        }
        ingredientRepository.save(ingredient);

        return ResponseEntity.ok(true);

    }

    public void deleteIngredient(Integer id) {
        ingredientRepository.deleteById(id);
    }
}
