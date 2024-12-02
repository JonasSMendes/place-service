package br.com.jonasSmendes.place_service.domain.repository;

import br.com.jonasSmendes.place_service.domain.Place;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PlaceRepository extends ReactiveCrudRepository<Place, Long> {
}
