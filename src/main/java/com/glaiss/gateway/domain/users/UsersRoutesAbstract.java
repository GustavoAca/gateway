package com.glaiss.gateway.domain.users;

import com.glaiss.gateway.domain.RoutesAbstract;
import com.glaiss.gateway.domain.Services;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

public abstract class UsersRoutesAbstract extends RoutesAbstract {

    protected abstract String getPath();

    @Override
    protected String getUri() {
        return LOAD_BALANCER.concat(Services.USERS.name());
    }

    protected void addRoute(RouteLocatorBuilder.Builder routes) {
    }
}
