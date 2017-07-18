package thread.ThreadDemo;

/**
 * 与线程中断有关的三个方法
 *      void Thread.interrupt()   //中断线程
 *      boolean Tread.isInterrupted()    //判断是否被中断
 *      boolean Thread.interrupted()      //判断是否被中断,并清除当前中断状态
 */
public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    Thread.yield();
                }
            }
        };

        thread1.start();
        Thread.sleep(2000);
        //此处使用interrupt中断线程,然而线程中并没有对中断做错响应因此并不会中断
        thread1.interrupt();


        /**
         * 现在线程中对中断做成响应
         */
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                while(true){
                    if(Thread.currentThread().isInterrupted()){
                        System.out.println("线程被中断,即将退出");
                        break;
                    }
                    Thread.yield();
                }
            }
        };
        thread2.start();

        Thread.sleep(2000);
        thread2.interrupt();

    }
}
