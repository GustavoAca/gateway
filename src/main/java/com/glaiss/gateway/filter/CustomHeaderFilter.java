package com.glaiss.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.stereotype.Component;

@Component
public class CustomHeaderFilter extends AbstractGatewayFilterFactory<Header> {

    public CustomHeaderFilter() {
        super(Header.class);
    }

    @Override
    public GatewayFilter apply(Header header) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();

            ServerHttpRequest modifiedRequest = new ServerHttpRequestDecorator(request) {
                @Override
                public org.springframework.http.HttpHeaders getHeaders() {
                    org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
                    headers.putAll(super.getHeaders());
                    headers.add(header.name(), header.value());
                    return headers;
                }
            };

            return chain.filter(exchange.mutate().request(modifiedRequest).build());
        };
    }
}

