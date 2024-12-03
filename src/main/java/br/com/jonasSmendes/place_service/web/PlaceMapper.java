package br.com.jonasSmendes.place_service.web;

import br.com.jonasSmendes.place_service.api.PlaceResponse;
import br.com.jonasSmendes.place_service.domain.Place;

public class PlaceMapper {
    public static PlaceResponse FromPlaceToResponse(Place place){
        return new PlaceResponse(
                place.slug(),
                place.name(),
                place.state(),
                place.createdAt(),
                place.updatedAt()
        );
    }
}
