import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.Semaphore;

public class Main{

    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException{

        Semaphore semaphore = new Semaphore(2);

        Thread holaAdios = new Thread(new HolaAdiosTask( semaphore));
        Thread saludado = new Thread( new YaSaludadoTask(semaphore));

//        try {
//            semaphore.acquire();
//        } catch (InterruptedException e){
//            e.printStackTrace();
//        }

        holaAdios.start();

        saludado.start();

        holaAdios.join();

        saludado.join();

        log.info("Ya ha terminado.");

    }
}
