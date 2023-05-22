package dat22v2.tb.pappaspizza.service;


import dat22v2.tb.pappaspizza.dto.APIWeatherResponse;
import dat22v2.tb.pappaspizza.dto.WeatherResponse;
import dat22v2.tb.pappaspizza.entity.Weather;
import dat22v2.tb.pappaspizza.repository.WeatherRepository;
import dat22v2.tb.pappaspizza.utility.APIkeyHolder;
import dat22v2.tb.pappaspizza.utility.MonoApiCaller;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class RemoteApiService {

    APIkeyHolder apiKeyHolder;
    WeatherRepository weatherRepository;

    public RemoteApiService(APIkeyHolder apiKeyHolder, WeatherRepository weatherRepository){
        this.apiKeyHolder = apiKeyHolder;
        this.weatherRepository = weatherRepository;
    }


    public WeatherResponse getCurrentWeather(double latitude, double longtitude) {

        LocalDateTime thirtyMinsLater = LocalDateTime.now().minusMinutes(3);

        Optional<Weather> weather = weatherRepository.findWeatherByCreationDateAfter(thirtyMinsLater);

        if(weather.isPresent()){
            return new WeatherResponse(weather.get());
        } else {

            //weatherRepository.deleteTopByOrderByCreationDateDesc();

            String OPEN_WEATHER_API_URL = "https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&appid=%s";
            APIWeatherResponse tmpWeatherResponse = MonoApiCaller.callGetApi(APIWeatherResponse.class, OPEN_WEATHER_API_URL,latitude,longtitude, apiKeyHolder.getWeatherAPIKey()).block();

            Optional<Weather> test = weatherRepository.findById(1);

            if(test.isPresent()){
                Weather outDatedWeather = test.get();
                outDatedWeather.setDescription(tmpWeatherResponse.getWeather().get(0).getDescription());
                outDatedWeather.setTemperature(tmpWeatherResponse.getMain().getTemp());
                outDatedWeather.setIcon(tmpWeatherResponse.weather.get(0).getIcon());
                outDatedWeather.setCreationDate(LocalDateTime.now());

                weatherRepository.save(outDatedWeather);
            } else {
                Weather tmpWeather = Weather.builder()
                        .description(tmpWeatherResponse.getWeather().get(0).getDescription())
                        .temperature(tmpWeatherResponse.getMain().getTemp())
                        .icon(tmpWeatherResponse.getWeather().get(0).getIcon())
                        .build();
                weatherRepository.save(tmpWeather);
            }
            WeatherResponse weatherResponse = new WeatherResponse(tmpWeatherResponse);
            return weatherResponse;
        }




    }

    /*
    public ChatGPTResponse getChatGPTResponse(ChatGPTRequest body){
        String OPENAI_API_URL = "https://api.openai.com/v1/chat/completions";
        return MonoApiCaller.callPostApi(ChatGPTResponse.class, OPENAI_API_URL,
            body, headersWithAuthorization(apiKeyHolder.getChatGPTAPIKey())).block();
    }
    */

    private Map<String, String> headersWithAuthorization(String bearerToken) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        headers.put("Authorization","Bearer " + bearerToken);
        return headers;
    }
}
