package com.opslab.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ZParams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by 0opslab
 */
public class _2RedisBase {


    /**
     * string类型的基本操作，string是redis的最基本数据类型，很多操作都是其他数据类型能用的，如del、exists、expire
     *
     * @throws Exception
     *
     */
    private static void string() throws Exception {
        Jedis jedis = new Jedis("localhost");
        jedis.flushDB(); // 清空数据库

        jedis.set("testString", "123"); // 往redis中放入字符串
        System.out.println("从redis中获取刚刚放进去的testString：" + jedis.get("testString"));

        jedis.incr("testString"); // 自增，不存在testInt则自增结果是1，如果不是字符串，自增会报JedisDataException
        System.out.println("从redis中获取自增后的testString：" + jedis.get("testString"));

        jedis.decr("testString"); // 自减，效果同自增
        System.out.println("从redis中获取自减后的testString：" + jedis.get("testString"));
        // incrby方法可以自定要增加多少

        jedis.append("testString", "456abcd"); // 在后面追加
        System.out.println("从redis中获取追加后的testString：" + jedis.get("testString"));

        String sub = jedis.substr("testString", 2, 6); // 切割字符串
        System.out.println("substr方法的返回值：" + sub);
        System.out.println("从redis中获取切割后的testString：" + jedis.get("testString")); // 可以看出，substr方法并不会破坏原有值，只是取出来加工而已

        jedis.rename("testString", "newString"); // 字段改名，值不会变
        System.out.println("testString改名成newString后，值为：" + jedis.get("newString"));

        String type = jedis.type("newString");// 获取其数据类型
        System.out.println("newString的数据类型是：" + type);

        long length = jedis.strlen("newString"); // 获取字符串长度
        System.out.println("newString的字符串长度为：" + length);

        jedis.set("testString6", "哈哈");
        jedis.set("testString7", "呵呵");
        jedis.set("testString8", "helloword");
        jedis.set("testString99", "SMSP");
        Set<String> keys = jedis.keys("*"); // 获取所有符合条件的键
        System.out.println("返回redis中所有的键：" + keys);
        keys = jedis.keys("*String?");
        System.out.println("返回redis中所有正则符合*String?的键：" + keys);

        jedis.del("testString"); // 字符串删除
        System.out.println("从redis删除testInt后，testInt是否还存在：" + jedis.exists("testString"));
        System.out.println();

        jedis.set("testString2", "你好啊！！！");
        jedis.expire("testString2", 2); // 设置有效期，单位是秒
        System.out.println("从redis中获取testString2的值为：" + jedis.get("testString2"));
        Thread.sleep(3000);
        System.out.println("3秒后从redis中获取testString2的值为：" + jedis.get("testString2")); // 过期了，会找不到该字段，返回null
        // ttl方法可以返回剩余有效时间，expire如果方法不指定时间，就是将该字段有效期设为无限
        System.out.println();
        System.out.println();
        jedis.close();
    }

    /**
     * list类的基本操作，有序可重复
     *
     */
    private static void list() {
        Jedis jedis = new Jedis("localhost");
        jedis.flushDB(); // 清空数据库

        // 列表的插入与获取(可以重复)
        jedis.lpush("testList", "Redis"); // 从左边插入
        jedis.lpush("testList", "Mongodb");
        jedis.lpush("testList", "Mysql");
        jedis.lpush("testList", "Mysql");
        jedis.rpush("testList", "DB2"); // 从右边插入

        List<String> list = jedis.lrange("testList", 0, -1); // 从左到右遍历，3个参数分别是，key，开始位置，结束位置（-1代表到最后）
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("从redis中获取刚刚放进去的testList[%d]: %s\n", i, list.get(i));
        }

        System.out.println();
        String lpop = jedis.lpop("testList"); // 删掉最左边的那个
        String rpop = jedis.rpop("testList"); // 删掉最右边的那个
        System.out.printf("被删的左边元素是：%s，被删的右边元素是：%s\n", lpop, rpop);

        list = jedis.lrange("testList", 0, -1);
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("从redis中获取被删除后的testList[%d]: %s\n", i, list.get(i));
        }

        System.out.println();
        jedis.ltrim("testList", 1, 2); // 裁剪列表，三个参数分别是，key，开始位置，结束位置
        list = jedis.lrange("testList", 0, -1);
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("从redis中获取被裁剪后的testList[%d]: %s\n", i, list.get(i));
        }

        jedis.del("testList"); // 删除列表
        System.out.println("从redis删除testList后，testList是否还存在：" + jedis.exists("testList"));
        System.out.println();
        System.out.println();
        jedis.close();
    }

    /**
     * 集合类型的基本操作，无序不重复
     */
    private static void set() {
        Jedis jedis = new Jedis("localhost");
        jedis.flushDB(); // 清空数据库

        jedis.sadd("testSet", "lida", "wch", "chf", "lxl", "wch"); // 添加元素，不可重复

        Set<String> set = jedis.smembers("testSet"); // 获取集合中的全部元素
        System.out.println("从testSet中获取的元素：" + set);

        long length = jedis.scard("testSet"); // 求集合的长度
        System.out.println("\n获取testSet的长度：" + length);
        System.out.println();

        jedis.srem("testSet", "wch"); // 从testSet移除wch
        set = jedis.smembers("testSet");
        System.out.println("从testSet中获取移除后的的元素：" + set);
        System.out.println();

        boolean exist = jedis.sismember("testSet", "lida"); // 判断元素是否包含在该集合中
        System.out.println("检查lida是否包含在testSet中：" + exist);
        System.out.println();

        String spop = jedis.spop("testSet");// 随机的移除spop中的一个元素，并返回它
        System.out.println("testSet中被随机移除的元素是：" + spop);
        System.out.println();

        jedis.del("testSet"); // 删除整个集合
        System.out.println("删除后，testSet是否还是存在：" + jedis.exists("testSet"));
        System.out.println();
        System.out.println();

        jedis.close();
    }

    /**
     * 集合之间的运算，交集、并集、差集
     */
    private static void sets() {
        Jedis jedis = new Jedis("localhost");
        jedis.flushDB(); // 清空数据库
        jedis.sadd("set1", "a", "b", "c", "d");
        jedis.sadd("set2", "b", "c", "e");

        Set<String> set = jedis.sdiff("set1", "set2"); // 求两个集合的差集（只会返回存在于1，但2不存在的）
        System.out.println("求出两个集合之间的差集：" + set); // 会输出a和d
        // 还有一个sdiffstore的api，可以把sdiff的计算结果赋值到另一个set中，下面的交集和并集也类似
        System.out.println();

        set = jedis.sinter("set1", "set2"); // 求两个集合的交集
        System.out.println("求出两个集合之间的交集：" + set); // 会输出b和c
        System.out.println();

        set = jedis.sunion("set1", "set2"); // 求两个集合的并集
        System.out.println("求出两个集合之间的并集：" + set);
        System.out.println();
        System.out.println();

        jedis.close();
    }

    /**
     * 散列的基本操作,键值对里面还有键值对，经常用来存储多个字段信息，也可以理解为存放一个map，散列是redis的存储原型
     */
    private static void hash() {
        Jedis jedis = new Jedis("localhost");
        jedis.flushDB(); // 清空数据库

        Map<String, String> map = new HashMap<String, String>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");
        map.put("k4", "123");
        jedis.hmset("hash1", map); // 存放一个散列

        Map<String, String> getMap = jedis.hgetAll("hash1"); // 从redis中取回来
        System.out.println("从redis中取回的hash1散列：" + getMap.toString());
        System.out.println();

        List<String> hmget = jedis.hmget("hash1", "k1", "k3"); // 从散列中取回一个或多个字段信息
        System.out.println("从hash1散列中两个字段来看看：" + hmget);
        System.out.println();

        jedis.hdel("hash1", "k1"); // 删除散列中的一个或者多个字段
        getMap = jedis.hgetAll("hash1");
        System.out.println("从redis中取回的被删除后的hash1散列：" + getMap);
        System.out.println();

        long length = jedis.hlen("hash1"); // 求出集合的长度
        System.out.println("散列hash1的长度为：" + length);
        System.out.println();

        boolean exists = jedis.hexists("hash1", "k5"); // 判断某个字段是否存在于散列中
        System.out.println("k5字段是否存在于散列中：" + exists);
        System.out.println();

        Set<String> keys = jedis.hkeys("hash1"); // 获取散列的所有字段名
        System.out.println("hash1的所有字段名：" + keys);
        System.out.println();

        List<String> values = jedis.hvals("hash1"); // 获取散列的所有字段值，实质的方法实现，是用上面的hkeys后再用hmget
        System.out.println("hash1的所有字段值：" + values);
        System.out.println();

        jedis.hincrBy("hash1", "k4", 10); // 给散列的某个字段进行加法运算
        System.out.println("执行加法运行后的hash1散列：" + jedis.hgetAll("hash1"));
        System.out.println();

        jedis.del("hash1"); // 删除散列
        System.out.println("删除hash1后，hash1是否还存在redis中：" + jedis.exists("hash1"));
        System.out.println();
        System.out.println();

        jedis.close();
    }

    /**
     * 有序集合的基本使用，zset是set的升级版，在无序的基础上，加入了一个权重，使其有序化<br/>
     * 另一种理解，zset是hash的特殊版，一样的存放一些键值对，但这里的值只能是数字，不能是字符串<br/>
     * zset广泛应用于排名类的场景
     */
    private static void zset() {
        Jedis jedis = new Jedis("localhost");
        jedis.flushDB(); // 清空数据库

        Map<String, Double> map = new HashMap<String, Double>();
        map.put("wch", 24.3); // 这里以小组成员的年龄来演示
        map.put("lida", 30.0);
        map.put("chf", 23.5);
        map.put("lxl", 22.1);
        map.put("wch", 24.3); // 这个不会被加入，应该重复了

        jedis.zadd("zset1", map); // 添加一个zset

        Set<String> range = jedis.zrange("zset1", 0, -1); // 从小到大排序，返回所有成员，三个参数：键、开始位置、结束位置（-1代表全部）
        // zrange方法还有很多衍生的方法，如zrangeByScore等，只是多了一些参数和筛选范围而已，比较简单，自己看看api就知道了
        System.out.println("zset返回的所有从小大到排序的成员：" + range);
        System.out.println("");

        Set<String> revrange = jedis.zrevrange("zset1", 0, -1); // 从大到小排序，类似上面的range
        System.out.println("zset返回的所有排序的成员：" + revrange);
        System.out.println("");

        long length = jedis.zcard("zset1"); // 求有效长度
        System.out.println("zset1的长度：" + length);
        System.out.println();

        long zcount = jedis.zcount("zset1", 22.1, 30.0); // 求出zset中，两个成员的排名之差，注意不是求长度，
        System.out.println("zset1中，22.1和30.0差了" + zcount + "名");
        System.out.println();

        long zrank = jedis.zrank("zset1", "wch"); // 求出zset中某成员的排位，注意第一是从0开始的
        System.out.println("wch在zset1中排名：" + zrank);
        System.out.println();

        double zscore = jedis.zscore("zset1", "lida"); // 获取zset中某成员的值
        System.out.println("zset1中lida的值为：" + zscore);
        System.out.println();

        jedis.zincrby("zset1", 10, "lxl"); // 给zset中的某成员做加法运算
        System.out.println("zset1中lxl加10后，排名情况为：" + jedis.zrange("zset1", 0, -1));
        System.out.println();

        jedis.zrem("zset1", "chf"); // 删除zset中某个成员
        // zrem还有衍生的zremByScore和zremByRank，分别是删除某个分数区间和排名区间的成员
        System.out.println("zset1删除chf后，剩下：" + jedis.zrange("zset1", 0, -1));
        System.out.println();

        jedis.close();
    }

    /**
     * 有序集合的运算，交集、并集（最小、最大、总和）
     */
    private static void zsets() {
        Jedis jedis = new Jedis("localhost");
        jedis.flushDB(); // 清空数据库

        Map<String, Double> map1 = new HashMap<String, Double>();
        map1.put("wch", 24.3); // 这里以小组成员的年龄来演示
        map1.put("lida", 30.0);
        map1.put("chf", 23.5);
        map1.put("lxl", 22.1);

        Map<String, Double> map2 = new HashMap<String, Double>();
        map2.put("wch", 24.3);
        map2.put("lly", 29.6);
        map2.put("chf", 23.5);
        map2.put("zjl", 21.3);

        jedis.zadd("zset1", map1);
        jedis.zadd("zset2", map2);

        System.out.println("zset1的值有：" + jedis.zrangeWithScores("zset1", 0, -1));
        System.out.println("zset2的值有：" + jedis.zrangeWithScores("zset2", 0, -1));
        System.out.println();

        // 把两个集合进行交集运算，运算结果赋值到zset_inter中
        jedis.zinterstore("zset_inter", "zset1", "zset2");
        System.out.println("看看两个zset交集运算结果：" + jedis.zrangeWithScores("zset_inter", 0, -1));

        // 把两个集合进行并集运算，运算结果赋值到zset_union中
        jedis.zunionstore("zset_union", "zset1", "zset2");
        System.out.println("看看两个zset并集运算结果：" + jedis.zrangeWithScores("zset_union", 0, -1));
        System.out.println("可以看出，zset的交集和并集计算，默认会把两个zset的score相加");

        ZParams zParams = new ZParams();
        zParams.aggregate(ZParams.Aggregate.MAX);
        // 通过指定ZParams来设置集合运算的score处理，有MAX MIN SUM三个可以选择，默认是SUM
        jedis.zinterstore("zset_inter", zParams, "zset1", "zset2");
        System.out.println("看看两个zset交集max运算结果：" + jedis.zrangeWithScores("zset_inter", 0, -1));

        //zrangeWithScores返回的是一个Set<Tuple>类型，如果直接把这个集合打印出来，会把zset的key转成ascii码，看起来不直观，建议还是使用foreach之类的遍历会好看一些

        jedis.close();
    }
}
