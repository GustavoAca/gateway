package com.glaiss.gateway.config;

import com.glaiss.gateway.domain.RouteDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class GatewayRoutesConfig {
    private final List<RouteDefinition> routeDefinitions;

    @Autowired
    public GatewayRoutesConfig(List<RouteDefinition> routeDefinitions) {
        this.routeDefinitions = routeDefinitions;
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routeDefinitions.forEach(definition -> definition.defineRoutes(routes));
        return routes.build();
    }
}
