package thread.ThreadGroup;

/**
 * Created by Administrator on 2016/10/18 0018.
 */
public class ThreadGroupDemo implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }

    public static void main(String[] args) {
        //创建一个线程组
        ThreadGroup threadGroup = new ThreadGroup("ThreadGroup");

        //往线程组中加入俩个线程
        new Thread(threadGroup,new ThreadGroupDemo(),"线程1").start();
        new Thread(threadGroup,new ThreadGroupDemo(),"线程2").start();




        threadGroup.list();
    }
}
