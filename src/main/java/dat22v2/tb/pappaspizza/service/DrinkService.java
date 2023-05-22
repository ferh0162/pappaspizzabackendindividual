package dat22v2.tb.pappaspizza.service;

import dat22v2.tb.pappaspizza.dto.drink.DrinkResponse;
import dat22v2.tb.pappaspizza.repository.DrinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkService {
  DrinkRepository drinkRepository;

  public DrinkService(DrinkRepository drinkRepository) {
    this.drinkRepository = drinkRepository;
  }

  public List<DrinkResponse> getDrinks(){
    return drinkRepository.findAll().stream().map(DrinkResponse::new).toList();
  }
}
