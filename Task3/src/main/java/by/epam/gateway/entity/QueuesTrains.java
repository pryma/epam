package by.epam.gateway.entity;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Максим&Маша on 22.06.14.
 */
public class QueuesTrains {

    private ConcurrentHashMap<Way, ConcurrentLinkedQueue<Train>> queues;
    private ConcurrentLinkedQueue<Train> queueEast;
    private ConcurrentLinkedQueue<Train> queueWest;

    private static final QueuesTrains QUEUES_TRAINS = new QueuesTrains();

    private QueuesTrains() {
        this.queueEast = new ConcurrentLinkedQueue<Train>();
        this.queueWest = new ConcurrentLinkedQueue<Train>();
        this.queues = new ConcurrentHashMap<Way, ConcurrentLinkedQueue<Train>>();
        this.queues.put(Way.WEST, queueWest);
        this.queues.put(Way.EAST, queueEast);
    }

    public static QueuesTrains getQueueTrains() {
        return QUEUES_TRAINS;
    }

    public Train getTrain(Way way) {
        return queues.get(way).poll();
    }

    public void setTrain(Way way, Train train) {
        queues.get(way).add(train);
    }

}
