package org.study.server.entity;

public enum HttpMethod {
    GET("GET", "GET"), POST("POST", "SAVE"), DELETE("DELETE");

    private final String name;
    private final String restAction;

    HttpMethod(String name) {
        this(name, name);
    }

    HttpMethod(String name, String restAction) {
        this.name = name;
        this.restAction = restAction;
    }

    public static HttpMethod getByName(String name) {
        HttpMethod[] values = values();
        for (HttpMethod httpMethod : values) {
            if (httpMethod.getName().equalsIgnoreCase(name)) {
                return httpMethod;
            }
        }
        throw new IllegalArgumentException("No method for name: " + name);
    }

    public String getName() {
        return name;
    }

    public String getRestAction() {
        return restAction;
    }
}
