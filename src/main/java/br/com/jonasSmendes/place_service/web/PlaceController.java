package br.com.jonasSmendes.place_service.web;

import br.com.jonasSmendes.place_service.api.PlaceRequest;
import br.com.jonasSmendes.place_service.api.PlaceResponse;
import br.com.jonasSmendes.place_service.domain.Place;
import br.com.jonasSmendes.place_service.domain.service.PlaceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/places")
public class PlaceController {

    private PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping
    public ResponseEntity<Mono<PlaceResponse>> create (@Valid @RequestBody PlaceRequest request){
        var placeResponse = placeService.create(request).map(PlaceMapper::FromPlaceToResponse);
        return ResponseEntity.status((HttpStatus.CREATED)).body(placeResponse);
    }
}
