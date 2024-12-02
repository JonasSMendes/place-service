package br.com.jonasSmendes.place_service.config;

import br.com.jonasSmendes.place_service.domain.repository.PlaceRepository;
import br.com.jonasSmendes.place_service.domain.service.PlaceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlaceConfig {

    @Bean
    PlaceService placeService(PlaceRepository placeRepository){
        return new PlaceService(placeRepository);
    }
}
