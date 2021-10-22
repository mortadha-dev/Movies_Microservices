package tun.dev.feign;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class AppController {
    MovieServiceClient movieServiceClient;
    public  AppController(MovieServiceClient movieServiceClient){
        this.movieServiceClient=movieServiceClient ;
    }

    @GetMapping("/fetchresponse")
    public List<Movie> fetchallmovies() {
        return movieServiceClient.getAllMovies();
    }


}