package com.jomchen.springtest.accessory.websockets;

import java.security.Principal;

/**
 * create by Jomchen on 8/18/18
 */
public class WebSocketUser implements Principal {

    private String name;
    private String password;

    public WebSocketUser(String name, String password) {
        this.name = name;
        this.password = password;
    }


    @Override
    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return password;
    }
}
