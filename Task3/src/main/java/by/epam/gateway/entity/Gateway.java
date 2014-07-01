package by.epam.gateway.entity;

import org.apache.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Максим&Маша on 22.06.14.
 */
public class Gateway implements Runnable {
    private static final Logger LOGGER = Logger.getLogger(Gateway.class);

    private int countTrainsRunOneWay;
    private QueuesTrains queuesTrains;
    private ExecutorService executorService = Executors.newCachedThreadPool();
    private Tunnel tunnel = new Tunnel(ALLOWABLE_COUNT_TRAINS_IN_TUNNEL);
    private Way way = Way.WEST;
    private static final int ALLOWABLE_COUNT_TRAINS_IN_TUNNEL = 2;
    private static final int ALLOWABLE_COUNT_TRAINS_RUN_ONE_WAY = 4;

    public void setQueueTrains(QueuesTrains queueTrains) {
        this.queuesTrains = queueTrains;
    }

    private Way changeWay(Way way) {
        if (way.equals(Way.WEST)) {
            return Way.EAST;
        } else {
            return Way.WEST;
        }
    }

    @Override
    public void run() {
        while (true) {

            if (countTrainsRunOneWay < ALLOWABLE_COUNT_TRAINS_RUN_ONE_WAY) {
                Train train;
                if ((train = queuesTrains.getTrain(way)) != null) {
                    tunnel.setTrain(train);
                    train.setTunnel(tunnel);
                    LOGGER.info("THREAD "+ Thread.currentThread().getName()+" execute Train by way : " + way);
                    executorService.execute(train);
                    countTrainsRunOneWay++;
                } else {
                    way = changeWay(way);
                }
            } else {
                while (tunnel.getQueue().size() != 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        LOGGER.error("Gateway interrupted", e);
                    }
                    countTrainsRunOneWay = 0;
                    way = changeWay(way);
                }

            }

        }
    }
}
