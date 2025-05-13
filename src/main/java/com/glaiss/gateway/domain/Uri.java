package com.glaiss.gateway.domain;

public enum Uri {
    LISTA("lista"),
    USERS("users"),
    NOTIFICATION("notification");

    private final String contextPath;

    Uri(String contextPath) {
        this.contextPath = contextPath;
    }

    public String getContextPath() {
        return this.contextPath;
    }
}
