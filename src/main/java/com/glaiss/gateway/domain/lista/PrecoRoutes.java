package com.glaiss.gateway.domain.lista;

import com.glaiss.gateway.domain.RoutesAbstract;
import com.glaiss.gateway.domain.Uri;
import org.springframework.stereotype.Component;

@Component
public class PrecoRoutes extends RoutesAbstract {

    protected PrecoRoutes() {
        super("precos", Uri.LISTA);
    }
}
