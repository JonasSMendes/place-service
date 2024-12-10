package br.com.jonasSmendes.place_service.domain.service;

import br.com.jonasSmendes.place_service.api.PlaceRequest;
import br.com.jonasSmendes.place_service.domain.Place;
import br.com.jonasSmendes.place_service.domain.repository.PlaceRepository;
import com.github.slugify.Slugify;
import reactor.core.publisher.Mono;

public class PlaceService {
    private PlaceRepository placeRepository;
    private Slugify slg;
    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
        this.slg = Slugify.builder().build();
    }

    public Mono<Place> create (PlaceRequest request){
        var place = new Place(
                null,
                request.name(),
                slg.slugify(request.name()),
                request.state(),
                null,
                null
        );
        System.out.println("Name: " + request.name());
        System.out.println("Slug: " + slg.slugify(request.name()));

        return placeRepository.save(place);
    }
}
