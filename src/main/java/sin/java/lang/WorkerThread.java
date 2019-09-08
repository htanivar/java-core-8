package sin.java.lang;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WorkerThread implements Runnable {

    private String name;

    public WorkerThread(final String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i <5 ; i++) {
            log.info("Thread Name: {}, Data: {}",Thread.currentThread().getName(),i);
            try{
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
