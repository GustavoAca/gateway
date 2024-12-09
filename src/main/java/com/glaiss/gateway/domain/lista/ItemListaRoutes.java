package com.glaiss.gateway.domain.lista;

import org.springframework.stereotype.Component;

@Component
public class ItemListaRoutes extends ListaRoutesAbstract {

    @Override
    protected String getPath() {
        return "/itens-lista";
    }
}
