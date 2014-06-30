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
        LOGGER.info(" Start run Train " + way);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            LOGGER.error("Train interrupted", e);
        }
        getTunnel().getQueue().remove(this);
        LOGGER.info(" Remove Train from Tunnel " + way);
    }
}
