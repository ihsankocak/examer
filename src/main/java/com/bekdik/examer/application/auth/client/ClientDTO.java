package com.bekdik.examer.application.auth.client;

public class ClientDTO {

    private String clientId;
    private String clientSecret;

    public ClientDTO(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }
}
