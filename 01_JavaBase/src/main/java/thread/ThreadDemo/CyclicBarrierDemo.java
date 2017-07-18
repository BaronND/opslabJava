package thread.ThreadDemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 字面意思回环栅栏，通过它可以实现让一组线程等待至某个状态之后再全部同时执行。
 * 叫做回环是因为当所有等待线程都被释放以后，CyclicBarrier可以被重用。我们暂
 * 且把这个状态就叫做barrier，当调用await()方法之后，线程就处于barrier了。
 *
 * 该方法主要的方法有
 *  CyclicBarrier(int parties,Runnable Action) 构造方法
 *  CyclicBarrier(int parties)
 *
 *  int await()
 *  int await(long timeout,TimeUnit unit)
 *  以上俩个方法都会使当前线程挂机知道所有的线程状态都达到barrier状态后继续执行
 */
public class CyclicBarrierDemo implements Runnable{
    private CyclicBarrier cyclicBarrier;

    public     CyclicBarrierDemo(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name+"线程开始执行");
        try {
            Thread.sleep(2000);
            System.out.println(name+"线程执行数据准备就绪，等待其他线程");
            cyclicBarrier.await();
            Thread.sleep(2000);
            System.out.println(name+"线程执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    /**
     * 所有线程到达barrier状态后触发
     */
    public static class AfterAction implements  Runnable{

        @Override
        public void run() {
            System.out.println("一组线程执行完成");
        }
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new AfterAction());
        for (int i = 0; i < 5; i++) {
            new Thread(new CyclicBarrierDemo(cyclicBarrier)).start();
        }


    }
}
