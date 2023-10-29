package com.tekion.cricketgame.exception;

public class TeamNotFoundException extends RuntimeException{
    public TeamNotFoundException(String message) {
        super(message);
    }
}
