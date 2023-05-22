package dat22v2.tb.pappaspizza.api;

import dat22v2.tb.pappaspizza.dto.WeatherResponse;
import dat22v2.tb.pappaspizza.service.RemoteApiService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/weather")
public class WeatherController {

    final double[] RESTAURANTCOORDS = {55.661262, 12.505435};

    RemoteApiService remoteApiService;

    public WeatherController(RemoteApiService remoteApiService) {
        this.remoteApiService = remoteApiService;
    }

        @GetMapping()
        WeatherResponse getCurrentWeather() {
            return remoteApiService.getCurrentWeather(RESTAURANTCOORDS[0],RESTAURANTCOORDS[1]);
        }


    }

