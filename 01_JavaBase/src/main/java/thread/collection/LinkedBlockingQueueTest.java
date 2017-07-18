package thread.collection;

import java.util.concurrent.*;

/**
 * 阻塞模式的生产者消费者模式
 * 方法\处理方式	抛出异常	返回特殊值	一直阻塞	超时退出
 * 插入方法	add(e)	    offer(e)	put(e)	offer(e,time,unit)
 * 移除方法	remove()	poll()	    take()	poll(time,unit)
 * 检查方法	element()	peek()	    不可用	不可用
 */
public class LinkedBlockingQueueTest {

    public static class Monitor implements Runnable{
        private BlockingQueue queue;

        public Monitor(BlockingQueue queue) {
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
        private BlockingQueue queue;

        public Producer(BlockingQueue queue) {
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
        private BlockingQueue queue;

        public Customer(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            if (queue != null && queue.size() > 0){
                Object poll = null;
                try {
                    poll = queue.take();
                    System.out.println("消费产品:"+poll);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingQueue(10);

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
