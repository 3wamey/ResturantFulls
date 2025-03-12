package com.spring.resturantfull.util;

import java.util.UUID;

public class UserCode {
    public static String extractCode(){
        return UUID.randomUUID().toString();
    }
}
