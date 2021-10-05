package tun.dev.moviescatalogservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Catalog {
    private String name ;
    private String desc ;
    private int rating  ;

}
