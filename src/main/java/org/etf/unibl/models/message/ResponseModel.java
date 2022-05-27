package org.etf.unibl.models.message;

import java.io.Serializable;

public class ResponseModel implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final String token;

    public ResponseModel(String token) {
        this.token = token;
    }
    public String getToken() {
        return token;
    }
}