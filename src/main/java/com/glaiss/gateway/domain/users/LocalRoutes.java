package com.glaiss.gateway.domain.users;

import com.glaiss.gateway.domain.RouteDefinition;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.stereotype.Component;

@Component
public class LocalRoutes implements RouteDefinition {
    private static final String path = "/locais";

    @Override
    public void defineRoutes(RouteLocatorBuilder.Builder routes) {
        routes.route(p ->
                        p.path(String.format("%s/**", path))
                                .uri("lb://USERS"))
                .build();
    }

}
