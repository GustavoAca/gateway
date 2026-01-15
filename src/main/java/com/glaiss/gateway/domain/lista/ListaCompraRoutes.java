package com.glaiss.gateway.domain.lista;

import com.glaiss.gateway.domain.RoutesAbstract;
import com.glaiss.gateway.domain.Uri;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.stereotype.Component;

@Component
public class ListaCompraRoutes extends RoutesAbstract {
    private static final String path = "listas-compras";

    protected ListaCompraRoutes() {
        super(path, Uri.LISTA);
    }

    @Override
    public void defineRoutes(RouteLocatorBuilder.Builder routes) {
        super.defineRoutes(routes);
        routes
                .route(getPath(), route -> route
                        .path("/listas-compras")
                        .filters(f -> f.rewritePath("/(?<segment>.*)", reescreverPath()))
                        .uri(formatarUri())
                ).build();
    }
}
