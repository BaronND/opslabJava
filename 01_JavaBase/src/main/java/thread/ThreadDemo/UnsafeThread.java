package thread.ThreadDemo;

/**
 * 只是一个不安全的线程实现
 */
public class UnsafeThread implements Runnable {

    private  int count = 10;
    @Override
    public void run() {
        while (count > 0){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+count);
            count--;
        }
    }

    public static void main(String[] args) {
        /**
         * 因为不是先线程安全的可能会输出0
         *
         */
        UnsafeThread unsafeThread = new UnsafeThread();
        Thread thread1 = new Thread(unsafeThread);
        Thread thread2 = new Thread(unsafeThread);

        thread1.start();
        thread2.start();
    }
}
