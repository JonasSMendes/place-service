package br.com.jonasSmendes.place_service;

import br.com.jonasSmendes.place_service.api.PlaceRequest;
import br.com.jonasSmendes.place_service.domain.Place;
import br.com.jonasSmendes.place_service.domain.service.PlaceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class PlaceServiceApplicationTests {


	@Autowired
	private WebTestClient webTestClient;
	@Test
	void testCreatePostSucess() {
		var name = "name name";
		var state = "state";
		var slug = "name-name";

		webTestClient
				.post()
				.uri("/places")
				.bodyValue(
						new PlaceRequest(name, state)
				)
				.exchange()
				.expectBody()
				.jsonPath("name").isEqualTo(name)
				.jsonPath("state").isEqualTo(state)
				.jsonPath("slug").isEqualTo(slug)
				.jsonPath("createdAt").isNotEmpty()
				.jsonPath("updatedAt").isNotEmpty();

	}

	@Test
	void testefail(){

	}

}
