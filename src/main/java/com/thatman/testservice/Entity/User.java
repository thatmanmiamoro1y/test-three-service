package com.thatman.testservice.Entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class User {
    private String userName;
    private String userPassword;

}
