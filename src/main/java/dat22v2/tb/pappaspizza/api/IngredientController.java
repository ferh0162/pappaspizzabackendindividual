package dat22v2.tb.pappaspizza.api;

import dat22v2.tb.pappaspizza.dto.ingredient.IngredientRequest;
import dat22v2.tb.pappaspizza.exception.IlegalIngredientException;
import dat22v2.tb.pappaspizza.service.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import dat22v2.tb.pappaspizza.dto.ingredient.IngredientResponse;
import dat22v2.tb.pappaspizza.service.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/ingredients")
public class IngredientController {

    IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService){
        this.ingredientService = ingredientService;
    }

    @GetMapping()
    public List<IngredientResponse> getAllIngredients(){
        return ingredientService.getAllIngredients();
    }

    @GetMapping("/{id}")
    public IngredientResponse getSpecificIngredient(@PathVariable Integer id){
        return ingredientService.getSpecificIngredient(id);
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping()
    public IngredientResponse addIngredient (@RequestBody IngredientRequest body) throws IlegalIngredientException {
        return ingredientService.addIngredient(body);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity editIngredient(@PathVariable Integer id, @RequestBody IngredientRequest body){
        ingredientService.editIngredient(id,body);
        return ResponseEntity.ok(true);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteIngredient(@PathVariable Integer id){
        ingredientService.deleteIngredient(id);
        return ResponseEntity.ok("Ingredient deleted successfully.");
    }

}