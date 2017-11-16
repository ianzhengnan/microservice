package com.example.spbootwebsocket.domain;

public class IanResponse {

    private String responseMessage;

    public IanResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}
