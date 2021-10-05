package tun.dev.moviescatalogservice;


import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collection.*;

@RestController
@RequestMapping("/catalog")
public class MoviesCatalogController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<Catalog> getCatalog(@PathVariable("userId") String userId) {

UserRating ratings = restTemplate.getForObject("http://rating-data-service/ratingsdata/user/" + userId, UserRating.class);

        return ratings.getRatings().stream()
                .map(rating -> {
                    Movie movie = restTemplate.getForObject("http://movies-info-service/movies/" + rating.getMovieId(), Movie.class);
                    return new Catalog(movie.getName(), movie.getName(), rating.getRating());
                })
                .collect(Collectors.toList());

    }

    }

