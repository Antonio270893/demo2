package mx.com.company.demo2.backend.dto;
import java.util.List;


public record  TvMazeSearchResponse(Double score, Show show) {
	public record Show(Long id, String name, String summary, List<String> genres, Network network, WebChannel webchannel) {}
	public record Network (String name){}	
	public record WebChannel (String name){}
}

