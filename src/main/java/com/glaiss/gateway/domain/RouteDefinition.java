package com.glaiss.gateway.domain;

import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

public interface RouteDefinition {
    void defineRoutes(RouteLocatorBuilder.Builder routes);
}
