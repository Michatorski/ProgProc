import java.util.concurrent.Semaphore;

public class PrintMessageTask implements Runnable {

    private Semaphore semaphore;
    private String message;
    private int times;
    private int sleep;

    public PrintMessageTask(Semaphore semaphore, String message, int times, int sleep) {
        this.semaphore = semaphore;
        this.message = message;
        this.times = times;
        this.sleep = sleep;
    }

    @Override
    public void run() {
        try{
            semaphore.acquire();

            for (int i = 0; i < times; i++) {
                System.out.println(message);
            }
            semaphore.release();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
