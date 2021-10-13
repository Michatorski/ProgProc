package org.iesfm.filesearch.taskExample;

public class SaludoTask implements Runnable {
    private String saludo;
    private long timeToSleep;

    public SaludoTask(String saludo, long timeToSleep) {
        this.saludo = saludo;
        this.timeToSleep = timeToSleep;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(saludo);

            try {
                Thread.sleep(timeToSleep);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
