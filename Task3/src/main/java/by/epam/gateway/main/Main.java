package by.epam.gateway.main;

import org.apache.log4j.Logger;

import by.epam.gateway.entity.Gateway;
import by.epam.gateway.entity.QueuesTrains;
import by.epam.gateway.entity.Train;
import by.epam.gateway.entity.Way;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Максим&Маша on 22.06.14.
 */
public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {

        QueuesTrains queueTrains = QueuesTrains.getQueueTrains();

        Random random = new Random();

        Gateway gateway1 = new Gateway();
        Gateway gateway2 = new Gateway();

        gateway1.setQueueTrains(queueTrains);
        gateway2.setQueueTrains(queueTrains);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(gateway1);
        executorService.execute(gateway2);

        for (int i = 0; i < 10; i++) {
            Train train = new Train();
            int way = random.nextInt(2000);
            if (way % 2 == 0) {
                train.setWay(Way.WEST);
                queueTrains.setTrain(Way.WEST, train);
                LOGGER.info("Create Train " + Way.WEST);
            } else {
                train.setWay(Way.EAST);
                queueTrains.setTrain(Way.EAST, train);
                LOGGER.info("Create Train " + Way.EAST);
            }

            Thread.sleep(1000);

        }

    }
}
