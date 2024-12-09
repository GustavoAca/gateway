package com.glaiss.gateway.domain.lista;

import org.springframework.stereotype.Component;

@Component
public class ItemRoutes extends ListaRoutesAbstract {

    @Override
    protected String getPath() {
        return "/itens";
    }
}
