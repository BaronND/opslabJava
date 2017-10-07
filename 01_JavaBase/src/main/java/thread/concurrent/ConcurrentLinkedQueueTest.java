package thread.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ConcurrentLinkedQueue是一个基于链接节点的无界线程安全队列
 * 所以当插入比取出的多很多的时候，系统会有严重的开销
 */
public class ConcurrentLinkedQueueTest {

    public static class Monitor implements Runnable{
        private ConcurrentLinkedQueue queue;

        public Monitor(ConcurrentLinkedQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            System.out.println("当前产品数量:"+queue.size());
        }

    }

    /**
     * 生产者
     */
    public static class Producer implements Runnable{
        private ConcurrentLinkedQueue queue;

        public Producer(ConcurrentLinkedQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("生产出:"+i);
                queue.offer(i);
            }
        }
    }

    public static class Customer implements Runnable{
        private ConcurrentLinkedQueue queue;

        public Customer(ConcurrentLinkedQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            if (queue != null && queue.size() > 0){
                Object poll = queue.poll();
                System.out.println("消费产品:"+poll);
            }
        }
    }

    public static void main(String[] args) {
        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        //启动生产
        //每10秒生产一次
        scheduledExecutorService.scheduleAtFixedRate(new Producer(queue),2,10, TimeUnit.SECONDS);

        /**
         * 每2秒大于一次
         */
        scheduledExecutorService.scheduleAtFixedRate(new Customer(queue),1,2,TimeUnit.SECONDS);

        /**
         * 每10秒打印队列的大小
         */
        scheduledExecutorService.scheduleAtFixedRate(new Monitor(queue),5,10,TimeUnit.SECONDS);
    }
}
