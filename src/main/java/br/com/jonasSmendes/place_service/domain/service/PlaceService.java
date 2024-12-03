package br.com.jonasSmendes.place_service.domain.service;

import br.com.jonasSmendes.place_service.api.PlaceRequest;
import br.com.jonasSmendes.place_service.api.PlaceResponse;
import br.com.jonasSmendes.place_service.domain.Place;
import br.com.jonasSmendes.place_service.domain.repository.PlaceRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

public class PlaceService {
    private PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public Mono<Place> create (PlaceRequest request){
        var place = new Place(
                null,
                request.name(),
                request.slug(),
                request.state(),
                request.createdAt(),
                request.updatedAt()
        );
        return placeRepository.save(place);
    }
}
