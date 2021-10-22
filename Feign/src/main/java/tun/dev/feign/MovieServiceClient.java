package tun.dev.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "movies-info-service")
public interface MovieServiceClient {

    @GetMapping(value = "/movies/get")
    public List<Movie> getAllMovies();
}