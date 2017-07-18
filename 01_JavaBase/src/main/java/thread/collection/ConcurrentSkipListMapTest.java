package thread.collection;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.Semaphore;

/**
 * ConcurrentSkipListMap的测试
 */
public class ConcurrentSkipListMapTest {
    private static Semaphore semaphore = new Semaphore(1);
    private static ConcurrentSkipListMap<Integer, Integer> concurrentSkipListMap =
            new ConcurrentSkipListMap<Integer, Integer>();

    public static void main(final String args[]) throws InterruptedException {


        new Thread("Thread1"){
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    concurrentSkipListMap.put(i, i*i);
                }
            }
        }.start();

        new Thread("Thread2"){
            @Override
            public void run() {
                for (int i = 10; i < 20; i++) {
                    concurrentSkipListMap.put(i, i*i);
                }

            }
        }.start();

        Thread.sleep(10000);


        new Thread("Thread3"){
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(concurrentSkipListMap.get(i));
                }
            }
        }.start();
    }
}
