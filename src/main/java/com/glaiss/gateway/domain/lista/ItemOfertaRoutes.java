package com.glaiss.gateway.domain.lista;

import com.glaiss.gateway.domain.RoutesAbstract;
import com.glaiss.gateway.domain.Uri;
import org.springframework.stereotype.Component;

@Component
public class ItemOfertaRoutes extends RoutesAbstract {
    private static final String path = "itens-oferta";

    protected ItemOfertaRoutes() {
        super(path, Uri.LISTA);
    }
}
