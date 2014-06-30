package by.epam.gateway.entity;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Максим&Маша on 22.06.14.
 */
public class Tunnel {

    private ConcurrentLinkedQueue<Train> queue = new ConcurrentLinkedQueue<Train>();

    public Train getTrain() {
        return queue.poll();
    }

    public void setTrain(Train train) {
        queue.add(train);
    }

    public ConcurrentLinkedQueue<Train> getQueue() {
        return queue;
    }

}
