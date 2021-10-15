import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Semaphore;

public class YaSaludadoTask implements Runnable {
    private final static Logger log = LoggerFactory.getLogger(YaSaludadoTask.class);

private Semaphore semaphore;

    public YaSaludadoTask(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        try {
            semaphore.acquire(2);
            log.info("Ya ha saludado");
            semaphore.release(1);
        } catch (InterruptedException e){
            e.printStackTrace();
        }


    }
}
