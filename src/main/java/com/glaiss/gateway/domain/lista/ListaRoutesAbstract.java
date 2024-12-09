package com.glaiss.gateway.domain.lista;

import com.glaiss.gateway.domain.RoutesAbstract;
import com.glaiss.gateway.domain.Services;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

public abstract class ListaRoutesAbstract extends RoutesAbstract {

    protected abstract String getPath();

    @Override
    protected String getUri() {
        return LOAD_BALANCER.concat(Services.LISTA.name());
    }

    protected void addRoute(RouteLocatorBuilder.Builder routes) {
    }
}
