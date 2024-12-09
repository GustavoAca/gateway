package com.glaiss.gateway.domain.users;

import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioRoutes extends UsersRoutesAbstract {

    @Override
    public void addRoute(RouteLocatorBuilder.Builder routes) {
        routes.route(p -> p
                        .path(String.format("%s/login", getPath()))
                        .uri(getUri()))
                .build();
    }

    @Override
    protected String getPath() {
        return "/usuarios";
    }
}
