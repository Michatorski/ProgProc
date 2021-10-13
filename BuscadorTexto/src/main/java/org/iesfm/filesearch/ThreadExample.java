package org.iesfm.filesearch;

public class ThreadExample {
    public static void main(String[] args) {

        Runnable task = new Runnable() {
            @Override
            public void run() {
                //lo que sea
            }
        };

        Thread t = new Thread(task);
        t.start();
    }
}
