package com.glaiss.gateway.domain.users;

import com.glaiss.gateway.domain.RoutesAbstract;
import com.glaiss.gateway.domain.Uri;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.stereotype.Component;

@Component
public class OauthRoutes extends RoutesAbstract {

    protected OauthRoutes() {
        super("oauth", Uri.USERS);
    }

    @Override
    public void defineRoutes(RouteLocatorBuilder.Builder routes) {
        super.defineRoutes(routes);
        routes
                .route(getPath(), route -> route
                        .path("/oauth/github")
                        .filters(f -> f.rewritePath("/(?<segment>.*)", reescreverPath()))
                        .uri(formatarUri())
                )
                .route(getPath(), route -> route
                        .path("/oauth/google")
                        .filters(f -> f.rewritePath("/(?<segment>.*)", reescreverPath()))
                        .uri(formatarUri())
                ).build();
    }
}
