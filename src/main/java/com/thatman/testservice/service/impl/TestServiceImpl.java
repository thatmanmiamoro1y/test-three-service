package com.thatman.testservice.service.impl;

import com.thatman.testservice.Entity.User;
import com.thatman.testservice.client.TestServiceOneClient;
import com.thatman.testservice.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService , ApplicationListener<WebServerInitializedEvent> {

    @Autowired
    TestServiceOneClient testServiceOneClient;

    @Value(value = "${userName:localhost-Name}")
    private String userName;
    @Value(value = "${userPassword:localhost-userPassword}")
    private String userPassword;

    private int port;

    @Override
    public User getUser() {
        System.out.println("--------->>>test-service-two:port:"+port);
        System.out.println("------------------->>"+this.userName);
        System.out.println("------------------->>"+this.userPassword);
        return null;
//        return testServiceOneClient.getUser();
    }

    @Override
    public void onApplicationEvent(WebServerInitializedEvent webServerInitializedEvent) {
        this.port=webServerInitializedEvent.getWebServer().getPort();
    }
}
