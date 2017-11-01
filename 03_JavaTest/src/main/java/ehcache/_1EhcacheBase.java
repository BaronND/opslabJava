package ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * Created by 0opslab
 * 演示简单的使用ehcache
 */
public class _1EhcacheBase {
    public static void main(String[] args) {
        //创建默认的cache管理器
        CacheManager cacheManager = CacheManager.create();
        //设置一个默认的cache集合
        Cache cache = new Cache("test", 1, true, false, 5, 2);
        cacheManager.addCache(cache);

        //向缓存中添加信息
        for (int i = 0; i < 100; i++) {
            cache.put(new Element("key-"+i,"value-"+i));
        }

        //遍历cache中元素
        for (int i = 0; i < 100; i++) {
            Element element = cache.get("key-"+i);
            System.out.println(element.getObjectValue());
        }

        //关闭缓存
        cacheManager.shutdown();

        System.exit(1);
    }
}
