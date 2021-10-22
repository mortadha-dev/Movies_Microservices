package tun.dev.moviescatalogservice.Controllers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import tun.dev.moviescatalogservice.entities.Movie;

import java.util.List;

@FeignClient(name = "movies-info-service")
public interface MovieServiceClient {

    @GetMapping(value = "/movies/get")
    public List<Movie> getAllMovies();
}