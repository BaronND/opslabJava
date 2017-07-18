package thread.ThreadDemo;

/**
 * JDK提供了来个非常重要的接口线程等待wait方法和通知notify方法
 * 当在一个对象实例上调用wait方法，那么当前线程就会等待，直到其他线程调用了对象的notify方法为止
 *
 *
 * 当调用notify是，它会冲这个对象的等待队列中，随机选择一个线程，并将其唤醒。
 * 当然也可以调用notifyAll方法唤醒所有在这个对象上等待的线程
 *
 *
 * 注意:
 *      无论是wait方法还是notify方法都需要首先获得目标对象的一个监视器，这就意味着他们需要在包含
 *      在synchronzied中
 */
public class WaitDemo {

    private final static Object obj = new Object();


    /**
     * 定义内部来
     */
    public static class Thread1 implements Runnable{
        @Override
        public void run() {
            System.out.println("线程1启动,即将进入wait状态");
            synchronized (obj) {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程1执行结束");
        }
    }

    public static class Thread2 implements Runnable{

        @Override
        public void run() {
            System.out.println("线程2启动，即将唤起等待的线程");
            synchronized (obj){
                obj.notify();
            }

            System.out.println("线程2执行结束");
        }
    }

    public static void main(String[] args) {
        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();
    }
}
