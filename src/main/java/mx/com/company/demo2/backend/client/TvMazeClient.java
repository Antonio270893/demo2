package mx.com.company.demo2.backend.client;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import mx.com.company.demo2.backend.dto.TvMazeSearchResponse;

@Component
public class TvMazeClient {
	private final RestClient restClient = RestClient.builder().baseUrl("https://api.tvmaze.com").build();

	public List<TvMazeSearchResponse> searchShows(String query) {
		TvMazeSearchResponse[] response = restClient.get()
				.uri(uriBuilder -> uriBuilder.path("/search/shows").queryParam("q", query).build()).retrieve()
				.body(TvMazeSearchResponse[].class);
		return response != null ? Arrays.asList(response) : List.of();

	}
	

    public Map<String, Object> getShowById(Long showId) {
        return restClient.get()
                .uri("/shows/{showId}", showId)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }
}
