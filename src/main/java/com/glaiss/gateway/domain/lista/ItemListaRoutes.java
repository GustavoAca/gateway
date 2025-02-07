package com.glaiss.gateway.domain.lista;

import com.glaiss.gateway.domain.RoutesAbstract;
import com.glaiss.gateway.domain.Uri;
import org.springframework.stereotype.Component;

@Component
public class ItemListaRoutes extends RoutesAbstract {

    protected ItemListaRoutes() {
        super("itens-lista", Uri.LISTA);
    }
}
