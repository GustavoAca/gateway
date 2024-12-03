package com.glaiss.gateway.domain.users;

import com.glaiss.gateway.domain.RouteDefinition;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioRoutes implements RouteDefinition {
    private static final String path = "/usuarios";

    @Override
    public void defineRoutes(RouteLocatorBuilder.Builder routes) {
        routes.route(p -> p
                        .path(String.format("%s/login", path))
                        .uri("lb://USERS"))
                .route(p ->
                        p.path(path)
                                .uri("lb://USERS"))
                .build();
    }
}
