package thread.collection;

import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap测试
 */
public class ConcurrentHashMapTest {

    private static ConcurrentHashMap<Integer, Integer> map =
                new ConcurrentHashMap<Integer, Integer>();


    public static void main(String[] args) {
        new Thread("Thread1"){
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    map.put(i, i*i);
                }
            }
        }.start();

        new Thread("Thread2"){
            @Override
            public void run() {
                for (int i = 10; i < 20; i++) {
                    map.put(i, i*i);
                }

            }
        }.start();

        new Thread("Thread3"){
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(map.get(i));
                }
            }
        }.start();


        System.out.println(map);
    }
}
