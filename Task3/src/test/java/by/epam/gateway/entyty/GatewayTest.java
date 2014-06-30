package by.epam.gateway.entyty;

import by.epam.gateway.entity.Gateway;
import by.epam.gateway.entity.QueuesTrains;
import by.epam.gateway.entity.Train;
import by.epam.gateway.entity.Way;
import org.junit.Test;

import java.util.Random;

/**
 * Created by Максим&Маша on 30.06.14.
 */
public class GatewayTest {

    @Test
    public void testRun() throws InterruptedException {

        QueuesTrains queueTrains = QueuesTrains.getQueueTrains();

        Random random = new Random();

        Gateway gateway1 = new Gateway();
        Gateway gateway2 = new Gateway();

        gateway1.setQueueTrains(queueTrains);
        gateway2.setQueueTrains(queueTrains);



        for (int i = 0; i < 10; i++) {
            Train train = new Train();
            int way = random.nextInt(2000);
            if (way % 2 == 0) {
                train.setWay(Way.WEST);
                queueTrains.setTrain(Way.WEST, train);
            } else {
                train.setWay(Way.EAST);
                queueTrains.setTrain(Way.EAST, train);
            }
    }
        Thread thread1 = new Thread(gateway1);
        Thread thread2 = new Thread(gateway2);
        thread1.run();
        thread2.run();
        //thread1.join();
        //thread2.join();
        //thread1.interrupt();
        //thread2.interrupt();
    }

}
