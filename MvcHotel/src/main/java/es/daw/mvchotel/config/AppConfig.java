package es.daw.mvchotel.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

    @Value("${daw.api.url}")
    private String habitacionUrl;

    @Value("${daw.api.url2}")
    private String hotelUrl;


    @Bean
    public WebClient webClientHotel(WebClient.Builder builder) {
        return builder
                .baseUrl(hotelUrl)
                .build();
    }

    @Bean
    public WebClient webClientHabitacion(WebClient.Builder builder) {
        return builder
                .baseUrl(habitacionUrl)
                .build();
    }


}