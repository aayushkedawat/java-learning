package com.sochaitea.runnerz;

import org.springframework.stereotype.Component;

@Component
public class WelcomeMessage {

    public String getWelcomeMessage(){
        return "Welcome to Aayush's First Application";
    }
}
