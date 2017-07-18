package thread.collection;

import java.util.ArrayList;

/**
 * ArrayList是非线程安全的
 *
 * 所以一下的代码很有可能结果并不是想象的20000 可能会比20000小 或者会出错
 */
public class ArrayListMutilThread {

    static ArrayList<Integer> list = new ArrayList();
    public static class Increment implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                list.add(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Increment increment = new Increment();
        Thread thread = new Thread(increment, "线程1");
        Thread thread1 = new Thread(increment, "线程2");

        thread.start();
        thread1.start();
        //等待俩个线程执行完
        thread.join();
        thread1.join();

        System.out.println(list.size());
    }
}
