package thread.ThreadDemo;

public class SafeThread implements Runnable {
    private int count = 10;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (this) {
                if (count > 0) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + count);
                    count--;
                }
            }
        }

    }

    public static void main(String[] args) {
        //定义线程对象
        SafeThread safeThread = new SafeThread();

        //定义线程对象
        Thread thread1 = new Thread(safeThread);
        Thread thread2 = new Thread(safeThread);

        thread1.start();
        thread2.start();
    }
}
