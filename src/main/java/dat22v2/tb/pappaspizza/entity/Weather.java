package dat22v2.tb.pappaspizza.entity;

import dat22v2.tb.pappaspizza.dto.WeatherResponse;
import dat22v2.tb.pappaspizza.dto.openWeather.Main;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    public String description;
    public double temperature;
    public String icon;
    @CreationTimestamp
    LocalDateTime creationDate;

}
