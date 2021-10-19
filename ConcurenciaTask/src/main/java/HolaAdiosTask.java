import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Semaphore;

public class HolaAdiosTask implements Runnable {

    private final static Logger log = LoggerFactory.getLogger(HolaAdiosTask.class);

    private Semaphore semaphore;

    public HolaAdiosTask( Semaphore semaphore)  {

        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire(2);

            for (int i = 0; i < 10; i++) {
                Thread.sleep(500);
               log.info("Hola mundo");

            }

            semaphore.release(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            semaphore.acquire(2);


            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                log.info("Adios");

            }

            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
