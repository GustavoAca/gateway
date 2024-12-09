package com.glaiss.gateway.domain;

import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

public abstract class RoutesAbstract implements RouteDefinition {
    protected final static String LOAD_BALANCER = "lb://";

    protected abstract String getPath();

    protected abstract String getUri();

    @Override
    public void defineRoutes(RouteLocatorBuilder.Builder routes) {
        routes.route(p ->
                p.path(getPath())
                        .uri(getUri()));
        addRoute(routes);
        routes.build();
    }

    protected abstract void addRoute(RouteLocatorBuilder.Builder routes);
}
