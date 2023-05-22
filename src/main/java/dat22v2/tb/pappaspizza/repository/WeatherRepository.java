package dat22v2.tb.pappaspizza.repository;

import dat22v2.tb.pappaspizza.entity.Weather;
import dat22v2.tb.pappaspizza.entity.user.User;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {
    Weather findTopByOrderByCreationDateDesc();

    Optional<Weather> findWeatherByCreationDateAfter(LocalDateTime localDateTime);

    void deleteTopByOrderByCreationDateDesc();

}
