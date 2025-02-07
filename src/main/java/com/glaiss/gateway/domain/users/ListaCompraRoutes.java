package com.glaiss.gateway.domain.users;

import com.glaiss.gateway.domain.RoutesAbstract;
import com.glaiss.gateway.domain.Uri;
import org.springframework.stereotype.Component;

@Component
public class ListaCompraRoutes extends RoutesAbstract {
    private static final String path = "/lista-compra";

    protected ListaCompraRoutes() {
        super("lista-compra", Uri.USERS);
    }
}
