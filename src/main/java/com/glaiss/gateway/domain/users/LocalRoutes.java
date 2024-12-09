package com.glaiss.gateway.domain.users;

import org.springframework.stereotype.Component;

@Component
public class LocalRoutes extends UsersRoutesAbstract {

    @Override
    protected String getPath() {
        return "/locais/**";
    }
}
