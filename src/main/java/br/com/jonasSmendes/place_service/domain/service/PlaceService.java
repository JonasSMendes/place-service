package br.com.jonasSmendes.place_service.domain.service;

import br.com.jonasSmendes.place_service.domain.Place;
import br.com.jonasSmendes.place_service.domain.repository.PlaceRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

public class PlaceService {
    private PlaceRepository placeRepository;


    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public Mono<Place> create (Place place){
        return placeRepository.save(place);
    }
}
