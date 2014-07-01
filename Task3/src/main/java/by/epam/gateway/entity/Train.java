package by.epam.gateway.entity;

import org.apache.log4j.Logger;

/**
 * Created by Максим&Маша on 22.06.14.
 */
public class Train implements Runnable{
    private static final Logger LOGGER = Logger.getLogger(Train.class);

    private Way way;
    private Tunnel tunnel;


    public Way getWay() {
        return way;
    }

    public void setWay(Way way) {
        this.way = way;
    }

    public Tunnel getTunnel() {
        return tunnel;
    }

    public void setTunnel(Tunnel tunnel) {
        this.tunnel = tunnel;
    }

    @Override
    public void run() {
        LOGGER.info("THREAD "+Thread.currentThread().getName()+" start run Train by way "+way);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            LOGGER.error("Train interrupted", e);
        }
        getTunnel().removeTrain(this);
        LOGGER.info("THREAD "+Thread.currentThread().getName()+" remove Train from Tunnel by way " + way);
    }
}
