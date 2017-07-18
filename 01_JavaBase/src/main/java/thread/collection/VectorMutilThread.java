package thread.collection;

import java.util.Vector;

/**
 * vector是线程安全的
 */
public class VectorMutilThread {
    static Vector<Integer> vector = new Vector();
    public static class Increment implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                vector.add(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Increment increment = new Increment();
        Thread thread = new Thread(increment);
        Thread thread1 = new Thread(increment);

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();

        System.out.println(vector.size());
    }
}
