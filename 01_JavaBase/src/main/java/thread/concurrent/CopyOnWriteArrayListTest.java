package thread.concurrent;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * CopyOnWriteArrayList 根据类名就可以知道该类的实现在某些操作中或执行一次copy
 * 因此有一定的开销，当然如果在读远远大于写的环境中这开销是值得的
 */
public class CopyOnWriteArrayListTest {

    /**
     * 读线程
     */
    public static class ReadTask implements Runnable{
        private List<Integer> list ;

        public ReadTask(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            if(list != null && list.size() > 0){
                for(Integer i:list){
                    System.out.println(name+":线程读取>"+i);
                }
            }
        }
        
        
    }

    public static class WriteTask implements Runnable{
        private List<Integer> list ;

        public WriteTask(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            for (int i = 0; i < 10; i++) {
                System.out.println(name+":线程更新数据");
                list.add(i);
            }
        }
    }

    public static void main(String[] args) {
        CopyOnWriteArrayList list = new CopyOnWriteArrayList();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        ReadTask readTask = new ReadTask(list);
        WriteTask writerTask = new WriteTask(list);

        scheduledExecutorService.scheduleAtFixedRate(writerTask,2,20, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(readTask,1,2,TimeUnit.SECONDS);

    }
}
