package com.abhi.sms;

public class Card {

    private String number;
    private String message;

    public Card(String number, String message) {
        this.number = number;
        this.message = message;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
