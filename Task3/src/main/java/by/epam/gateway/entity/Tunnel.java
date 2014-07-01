package by.epam.gateway.entity;

import org.apache.log4j.Logger;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Максим&Маша on 22.06.14.
 */
public class Tunnel {
    private static final Logger LOGGER = Logger.getLogger(Tunnel.class);

    private BlockingQueue<Train> queue;

    public Tunnel(int capacity) {
        this.queue = new ArrayBlockingQueue<Train>(capacity);
    }

    public boolean removeTrain(Train train) {
        return queue.remove(train);
    }

    public Train getTrain() {
        return queue.poll();
    }

    public void setTrain(Train train) {
        try {
            queue.put(train);
        } catch (InterruptedException e) {
            LOGGER.error("Gateway interrupted", e);
        }
    }

    public BlockingQueue<Train> getQueue() {
        return queue;
    }

}
