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
        routes.route(p ->
                        p.path(String.format("/%s/login", this.path))
                                .uri(String.format("lb://%s", this.uri)))
                .route(p ->
                        p.path(String.format("/%s/cadastrar", this.path))
                                .uri(String.format("lb://%s", this.uri)));
    }
}
