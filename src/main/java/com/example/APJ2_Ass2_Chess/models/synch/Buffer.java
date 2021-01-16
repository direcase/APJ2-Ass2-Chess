package com.example.APJ2_Ass2_Chess.models.synch;

public interface Buffer {
    public void blockingPut(String value) throws InterruptedException;
    public String blockingGet() throws InterruptedException;
}
