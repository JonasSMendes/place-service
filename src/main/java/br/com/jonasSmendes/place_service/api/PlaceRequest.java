package br.com.jonasSmendes.place_service.api;

import java.time.LocalDateTime;

public record PlaceRequest(
        String name, String state
) {
}
