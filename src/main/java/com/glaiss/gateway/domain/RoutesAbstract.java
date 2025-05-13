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
        routes.route(getPath(), p ->
                p.path(getPath())
                        .filters(f ->
                                f.rewritePath("/(?<segment>.*)", reescreverPath()))
                        .uri(formatarUri()));
        routes.build();
    }

    public String getPath() {
        return String.format("/%s/**", this.path);
    }

    public String reescreverPath() {
        return String.format("/%s/${segment}", this.uri.getContextPath());
    }

    public String formatarUri() {
        return String.format("lb://%s", this.uri.name());
    }
}
