package tun.dev.moviescatalogservice.Controllers;
import org.springframework.web.bind.annotation.*;
import tun.dev.moviescatalogservice.entities.Catalog;
import tun.dev.moviescatalogservice.repositories.CatalogRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MoviesCatalogController {
    CatalogRepository catalogRepository ;
    MovieServiceClient movieServiceClient;

    public MoviesCatalogController(CatalogRepository catalogRepository, MovieServiceClient movieServiceClient){
        this.movieServiceClient =movieServiceClient ;
        this.catalogRepository=catalogRepository ;
    }

    @RequestMapping("/post")
    public void addCatalog() {
        Catalog catalog = new Catalog();
        catalog.setId("1");
        catalog.setName("first categorie");
        catalog.setMovies(movieServiceClient.getAllMovies());
        catalog.setRating( 5 );
        catalog.setDescription("description of movie");
        catalogRepository.save(catalog) ;
    }
    @GetMapping("/getCatalogs")
    public List<String> getCatalogs(){
        ArrayList<String > response = new ArrayList<>() ;
        response.add(movieServiceClient.getAllMovies().toString()) ;
        response.add(catalogRepository.findAll().toString());
        return  response ;
      // return (List<Catalog>) catalogRepository.findAll();
    }
}

