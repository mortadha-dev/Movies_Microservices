package tun.dev.moviescatalogservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tun.dev.moviescatalogservice.entities.Catalog;

@Repository
public interface CatalogRepository  extends CrudRepository<Catalog, String> {
}
