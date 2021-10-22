package tun.dev.moviesinfoservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tun.dev.moviesinfoservice.entities.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {
}
