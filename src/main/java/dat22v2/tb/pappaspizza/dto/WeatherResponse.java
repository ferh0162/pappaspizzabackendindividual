package dat22v2.tb.pappaspizza.dto;

import dat22v2.tb.pappaspizza.entity.Weather;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherResponse {
    public String description;
    public double temperature;
    public String icon;

    public WeatherResponse(Weather weather){
        this.description = weather.getDescription();
        this.temperature = weather.getTemperature();
        this.icon = weather.getIcon();
    }

    public WeatherResponse(APIWeatherResponse tmpWeatherResponse) {
        this.description = tmpWeatherResponse.getWeather().get(0).getDescription();
        this.temperature = tmpWeatherResponse.getMain().getTemp();
        this.icon = tmpWeatherResponse.getWeather().get(0).getIcon();
    }
}
