package com.glaiss.gateway.domain.lista;

import com.glaiss.gateway.domain.RoutesAbstract;
import com.glaiss.gateway.domain.Uri;
import org.springframework.stereotype.Component;

@Component
public class ListaCompraRoutes extends RoutesAbstract {
    private static final String path = "listas-compras";

    protected ListaCompraRoutes() {
        super(path, Uri.LISTA);
    }
}
