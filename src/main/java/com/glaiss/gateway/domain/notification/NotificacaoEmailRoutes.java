package com.glaiss.gateway.domain.notification;

import com.glaiss.gateway.domain.RoutesAbstract;
import com.glaiss.gateway.domain.Uri;
import com.glaiss.gateway.filter.CustomHeaderFilter;
import com.glaiss.gateway.filter.Header;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoEmailRoutes extends RoutesAbstract {

    private final CustomHeaderFilter customHeaderFilter;

    protected NotificacaoEmailRoutes(CustomHeaderFilter customHeaderFilter) {
        super("notificacao-por-email", Uri.NOTIFICATION);
        this.customHeaderFilter = customHeaderFilter;
    }

    @Value("${security.notification.api-key}")
    private String headerValue;

    @Override
    public void defineRoutes(RouteLocatorBuilder.Builder routes) {
        Header header = new Header("X-CHAVE-DE-ACESSO", headerValue);
        routes.route(getPath(), p ->
                p.path(getPath())
                        .filters(f ->
                                f
                                        .rewritePath("/(?<segment>.*)", reescreverPath())
                                        .filter(customHeaderFilter.apply(header))
                        )
                        .uri(formatarUri()));
        routes.build();
    }
}
