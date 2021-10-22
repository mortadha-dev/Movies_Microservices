package tun.dev.moviescatalogservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Catalog {
    @Id
    private String id ;
    private String name;
    private String description;
    @Transient
    private List<Movie> movies ;
    private int rating;

}
