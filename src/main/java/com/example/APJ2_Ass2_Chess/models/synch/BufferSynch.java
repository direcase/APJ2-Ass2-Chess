package com.example.APJ2_Ass2_Chess.models.synch;

import com.example.APJ2_Ass2_Chess.models.synch.Buffer;

import java.util.concurrent.ArrayBlockingQueue;

public class BufferSynch implements Buffer {
    private final ArrayBlockingQueue<String> buffer; // shared buffer
    private boolean occupied = false;

    public BufferSynch() {
        buffer = new ArrayBlockingQueue<String>(1);
    }
    @Override
    public synchronized void blockingPut(String value) throws InterruptedException
    {
        while (occupied) {
            wait();
        }
        buffer.put(value);
        occupied = true;
        notifyAll();
        /*System.out.printf("%s%2d\t%s%d%n", "Producer writes ", value,
                "Buffer cells occupied: ", buffer.size());*/
    }
    // return value from buffer
    @Override
    public synchronized String blockingGet() throws InterruptedException {
        while (!occupied)
        {
            wait();
        }
        occupied = false;
        String readValue = buffer.take();
        notify();
        /*System.out.printf("%s %2d\t%s%d%n", "Consumer reads ",
                readValue, "Buffer cells occupied: ", buffer.size());*/
        return readValue;
    }
}
