package com.glaiss.gateway.domain.users;

import com.glaiss.gateway.domain.RoutesAbstract;
import com.glaiss.gateway.domain.Uri;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioRoutes extends RoutesAbstract {

    protected UsuarioRoutes() {
        super("usuarios", Uri.USERS);
    }

    @Override
    protected void adicionarRoutes(RouteLocatorBuilder.Builder routes) {
        routes
                .route("usuarios-login", route -> route
                        .path("/usuarios/login")
                        .filters(f -> f.rewritePath("/(?<segment>.*)", String.format("/%s/${segment}", this.uri.getContextPath())))
                        .uri("lb://USERS")
                )
                .route("usuarios-cadastrar", route -> route
                        .path("/usuarios/cadastrar")
                        .filters(f -> f.rewritePath("/(?<segment>.*)", String.format("/%s/${segment}", this.uri.getContextPath())))
                        .uri("lb://USERS")
                );
    }
}
