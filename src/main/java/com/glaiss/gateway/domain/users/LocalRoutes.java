package com.glaiss.gateway.domain.users;

import com.glaiss.gateway.domain.RoutesAbstract;
import com.glaiss.gateway.domain.Uri;
import org.springframework.stereotype.Component;

@Component
public class LocalRoutes extends RoutesAbstract {
    private static final String path = "/locais";

    protected LocalRoutes() {
        super("locais", Uri.USERS);
    }
}
