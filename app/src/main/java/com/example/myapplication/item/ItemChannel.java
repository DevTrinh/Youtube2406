package com.example.myapplication.item;

public class ItemChannel {
    private String avtChannel;
    private String subscriberNumber;

    public ItemChannel(String avtChannel, String subscriberNumber) {
        this.avtChannel = avtChannel;
        this.subscriberNumber = subscriberNumber;
    }

    public String getAvtChannel() {
        return avtChannel;
    }

    public void setAvtChannel(String avtChannel) {
        this.avtChannel = avtChannel;
    }

    public String getSubscriberNumber() {
        return subscriberNumber;
    }

    public void setSubscriberNumber(String subscriberNumber) {
        this.subscriberNumber = subscriberNumber;
    }
}
