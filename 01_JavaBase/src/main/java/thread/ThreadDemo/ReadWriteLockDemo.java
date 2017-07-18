package thread.ThreadDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 */
public class ReadWriteLockDemo implements Runnable {


    static Map<String, Object> map = new HashMap<String, Object>();
    static ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock(true);

    static Lock readLock = rwLock.readLock();

    static Lock writeLock = rwLock.writeLock();

    public static final Object get(String key) {
        //获取读锁
        readLock.lock();
        try {
            return map.get(key);
        } finally {
            //释放读锁
            readLock.unlock();
        }

    }

    public static final void put(String key, Object obj) {
        writeLock.lock();
        try {
            map.put(key, obj);
        } finally {
            writeLock.unlock();
        }
    }


    private int type;

    public ReadWriteLockDemo(int type) {
        this.type = type;
    }

    @Override
    public void run() {
        if (type == 1) {
            for (int i = 0; i < 100; i++) {
                System.out.println(ReadWriteLockDemo.get(String.valueOf(i)));
            }
        } else {
            for (int i = 0; i < 100; i++) {
                ReadWriteLockDemo.put(String.valueOf(i), i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ReadWriteLockDemo(0)).start();
        new Thread(new ReadWriteLockDemo(0)).start();
        new Thread(new ReadWriteLockDemo(1)).start();
        new Thread(new ReadWriteLockDemo(1)).start();
        new Thread(new ReadWriteLockDemo(1)).start();

        Thread.sleep(10000);
    }
}
