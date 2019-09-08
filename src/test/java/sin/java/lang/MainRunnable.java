package sin.java.lang;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainRunnable {
    public static void main(String[] args) {
      log.info("Started Main Thread");
      final Thread thread = new Thread(new WorkerThread("Process data through Runnable Interface"));
      thread.start();
      thread.setName("Demo Thread");
      log.info("Completed Main Thread");
    }
}
