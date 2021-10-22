package tun.dev.moviesinfoservice.Controllers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.env.Environment;
import tun.dev.moviesinfoservice.entities.Movie;
import tun.dev.moviesinfoservice.repositories.MovieRepository;
import java.util.List;

@RestController
@RequestMapping("/movies")
@CrossOrigin("*")
public class MovieController {

    @Value("${greeting}")
    private String message;
    @Value("${nom}")
    private String nom;
    @Value("${prenom}")
    private String prenom;
    Environment environment;
    MovieRepository movieRepository ;
    public MovieController(Environment environment , MovieRepository movieRepository){
        this.environment=environment ;
        this.movieRepository=movieRepository ;
    }
    @GetMapping("/get")
    public List<Movie> getMovies() {
        System.out.println("hahahah");
        return (List<Movie>) movieRepository.findAll();
           /* String env = environment.getProperty("local.server.port");
        List response = new List() ;
        response.add(movieRepository.findAll()) ;
         response.add(env);
        return response ;*/
    }


    @GetMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") int movieId) {
        return movieRepository.findById(movieId).get() ;

    }
@PostMapping("/addMovie")
public void addMovie(@RequestBody Movie movie){
    System.out.println("iam gettting there ");
        movieRepository.save(movie) ;

}
    @GetMapping("/testing")
    public String testing() {
        return message + nom + prenom;
    }
}
