package com.glaiss.gateway.domain;

import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

public abstract class RoutesAbstract implements RouteDefinition {

    protected final String path;
    protected final Uri uri;

    protected RoutesAbstract(String path, Uri uri) {
        this.path = path;
        this.uri = uri;
    }

    @Override
    public void defineRoutes(RouteLocatorBuilder.Builder routes) {
        routes.route(p ->
                p.path(String.format("/%s/**", this.path))
                        .uri(String.format("lb://%s", this.uri.name())));
        adicionarRoutes(routes);
        routes.build();

    }

    protected void adicionarRoutes(RouteLocatorBuilder.Builder routes) {
    }
}
