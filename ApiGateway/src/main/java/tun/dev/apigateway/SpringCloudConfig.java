package tun.dev.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig
{
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder routeLocatorBuilder)
    {
        return routeLocatorBuilder.routes()
                .route("moviesinfos", rt -> rt.path("/movies/**")
                        .uri("http://localhost:8020/")
                )
                .route("catalog", rt -> rt.path("/catalog/**")
                        .uri("http://localhost:8010/"))
                .route("feign", rt -> rt.path("/**")
                        .uri("http://localhost:8090/"))
                .route("ratingmovies", rt -> rt.path("/ratingmovies/userrating/**")
                        .uri("http://localhost:8030/"))
                .route("catalog", rt -> rt.path("/catalog/**")
                        .uri("http://localhost:8010/"))

                .build();

    }
}