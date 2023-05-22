package dat22v2.tb.pappaspizza.api;


import dat22v2.tb.pappaspizza.dto.drink.DrinkResponse;
import dat22v2.tb.pappaspizza.service.DrinkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/drinks")
@CrossOrigin
public class DrinkController {

    DrinkService drinkService;

    public DrinkController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    @GetMapping
    public ResponseEntity<List<DrinkResponse>> getDrinks() {
        return ResponseEntity.ok(drinkService.getDrinks());


    }

}
