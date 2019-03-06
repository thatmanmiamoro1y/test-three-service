package com.thatman.testservice.client;


import com.thatman.testservice.Entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(name = "test-service-one",fallback = TestServiceOneClientFallback.class)
public interface TestServiceOneClient {

    @GetMapping(value ="test-service-one/test/getUser")
    User getUser();

}
