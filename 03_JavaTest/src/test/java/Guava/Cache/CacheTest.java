package Guava.Cache;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Ignore;
import org.junit.Test;

/**
 * 通常来说，Guava Cache适用于：
 * 1。愿意消耗一些内存空间来提升速度。
 * 2。预料到某些键会被查询一次以上。
 * 3。缓存中存放的数据总量不会超出内存容量。
 * （GuavaCache是单个应用运行时的本地缓存。它不把数据存放到文件或外部服务器。如果这不符合你的需求，请尝试Memcached这类工具）
 */

public class CacheTest {
    @Test
    @Ignore
    public  void cacheTest() {
        // LoadingCache<Key, Graph> graphs = CacheBuilder.newBuilder()
        // .maximumSize(1000)
        // .expireAfterWrite(10, TimeUnit.MINUTES)
        // .removalListener(MY_LISTENER)
        // .build(
        // new CacheLoader<Key, Graph>() {
        // public Graph load(Key key) throws AnyException {
        // return createExpensiveGraph(key);
        //
        //
        // }
        // }});

        // CacheLoader
        // LoadingCache是附带CacheLoader构建而成的缓存实现。
        // 创建自己的CacheLoader通常只需要简单地实现V load(K key) throws Exception方法。
        LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(1000).build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        // 实现了模式"如果有缓存则返回；否则运算、缓存、然后返回"。
                        return "null";
                    }
                });
        cache.put("a", "aaaaaa");
        try {
            System.out.println(cache.get("a"));// aaaaaa
            System.out.println(cache.get("bb"));// null----key不存在,使用CacheLoader向缓存原子地加载新值
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // 也可以在调用get时,指定Callable
        Cache<String, String> cache1 = CacheBuilder.newBuilder()
                .maximumSize(1000)// 规定缓存项的数目不超过固定值,逼近限定值时将尝试回收最近没有使用或总体上很少使用的缓存项。
                .build(); // no CacheLoader
        try {
            // If the key wasn't in the "easy to compute" group,
            // we need to do things the hard way.
            String aString = cache1.get("a", new Callable<String>() {
                @Override
                public String call() throws Exception {
                    // TODO Auto-generated method stub
                    return "nullnullnull";
                }
            });
            System.out.println(aString);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // 不同的缓存项有不同的“权重”（weights）
        // 可以使用CacheBuilder.weigher(Weigher)指定一个权重函数，
        // 并且用CacheBuilder.maximumWeight(long)指定最大总重

        // 定时回收（Timed Eviction）
        // expireAfterAccess(long, TimeUnit)：
        // -----缓存项在给定时间内没有被读/写访问，则回收。请注意这种缓存的回收顺序和基于大小回收一样。
        // expireAfterWrite(long, TimeUnit)：
        // -----缓存项在给定时间内没有被写访问（创建或覆盖），则回收。如果认为缓存数据总是在固定时候后变得陈旧不可用，这种回收方式是可取的。

        // 移除监听器
        // 通过CacheBuilder.removalListener(RemovalListener)，
        // 可以声明一个监听器，以便缓存项被移除时做一些额外操作。
        // 缓存项被移除时，RemovalListener会获取移除通知[RemovalNotification]，其中包含移除原因[RemovalCause]、键和值。
    }
}
