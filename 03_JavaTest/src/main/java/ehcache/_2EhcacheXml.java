package ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * Created by 0opslab
 * 从xml配置文件中获取cache配置信息
 */
public class _2EhcacheXml {
    public static void main(String[] args) {

        //从class目录中自动查找ehcache.xml配置文件
        CacheManager cacheManager = CacheManager.getInstance();

        //取出所有的cacheName
        String names[] = cacheManager.getCacheNames();
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

        //根据xml中的配置信息获取知道的缓存集合
        Cache sampleCache2 = cacheManager.getCache("sampleCache2");

        //向缓存中添加原生
        for (int i = 0; i < 100; i++) {
            sampleCache2.put(new Element("key-"+i,"value-"+i));
        }

        //遍历cache中元素
        for (int i = 0; i < 100; i++) {
            Element element = sampleCache2.get("key-"+i);
            System.out.println(element.getObjectValue());
        }

        //关闭缓存
        cacheManager.shutdown();
    }
}
