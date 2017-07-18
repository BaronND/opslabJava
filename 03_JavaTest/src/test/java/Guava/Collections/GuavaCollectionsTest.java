package Guava.Collections;

import com.google.common.collect.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Guava对JDK集合的扩展
 *
 * @author zero
 */
public class GuavaCollectionsTest {

    public static void main(String[] args) {
        // 1.简化集合的创建
        Map<String, Map<String, String>> map1 = Maps.newHashMap();
        List<List<Map<String, String>>> arrayList = Lists.newArrayList();
        List<String> exactly100 = Lists.newArrayListWithCapacity(100);
        List<String> linkedList = Lists.newLinkedList();
        Set<String> Set = Sets.newHashSet();
        Map<String, String> map2 = Maps.newHashMap();
        Integer[] intArrays = ObjectArrays.newArray(Integer.class, 10);

        // 2.简化集合的初始化
        Set<String> set = Sets.newHashSet("one", "two", "three");
        List<String> list1 = Lists.newArrayList("one", "two", "three");
        Set<String> set2 = Sets.newHashSet(new String("a"), new String("b"));

        Set<String> set1 = ImmutableSet.of("one", "two", "three");// 不可变集合
        // 或则调用ImmutableSet.copyOf(set)来创建 不可变集合
        Map<String, String> map3 = ImmutableMap
                .of("ON", "TRUE", "OFF", "FALSE");
        // map3.put("a", "c")-----抛出java.lang.UnsupportedOperationException
        // Builder工具创建 不可变集合
        ImmutableSet<String> set4 = ImmutableSet.<String>builder()
                .add(new String("a")).add(new String("b")).add(new String("a"))
                .build();
        System.out.println(set4);// [a, d]
        // 对有序不可变集合来说，排序是可以在构造集合的时候完成
        Set<String> set5 = ImmutableSortedSet.of("a", "b", "c", "a", "d", "b");
        System.out.println(set5);// [a, b, c, d]

        // asList视图,所有不可变集合都有一个asList()方法提供ImmutableList视图
        System.out.println(set4.asList().get(1));// b

        // 3.新的集合类型
        // 3.1 MultiMap
        // key可以重复的map，子类有ListMultimap和SetMultimap，对应的通过key分别得到list和set
        Multimap<String, String> customersByType = ArrayListMultimap.create();
        customersByType.put("abc", new String("aaa"));
        customersByType.put("abc", new String("bbb"));
        customersByType.put("abc", new String("ccc"));
        customersByType.put("abc", new String("ddd"));
        customersByType.put("abcd", new String("eee"));
        customersByType.put("abcde", new String("fff"));
        // 以集合形式返回键所对应的值视图，即使没有任何对应的值，也会返回空集合
        System.out.println(customersByType.get("abc"));// aaa bbb ccc ddd
        // ListMultimap.get(key)返回List，SetMultimap.get(key)返回Set。

        // 3.2 MultiSet(场景：统计一个词在文档中出现了多少次)
        // 不是集合，可以增加重复的元素，并且可以统计出重复元素的个数
        // Multiset元素的顺序是无关紧要的：Multiset {a, a, b}和{a, b, a}是相等的
        Multiset<Integer> multiSet = HashMultiset.create();
        multiSet.add(10);
        multiSet.add(30);
        multiSet.add(30);
        multiSet.add(40);
        System.out.println(multiSet.count(30)); // 2
        System.out.println(multiSet.size()); // 4
        // add(E, int)------增加给定元素在Multiset中的计数
        // remove(E, int)------减少给定元素在Multiset中的计数
        // setCount(E, int)-----设置给定元素在Multiset中的计数，不可以为负数

        // 3.3 Table
        // 相当于有两个key的map
        Table<Integer, Integer, String> personTable = HashBasedTable.create();
        personTable.put(1, 20, new String("1--20"));
        personTable.put(0, 30, new String("0--30"));
        personTable.put(0, 25, new String("0--25"));
        personTable.put(1, 50, new String("1--50"));
        personTable.put(0, 27, new String("0--27"));
        personTable.put(1, 29, new String("1--29"));
        personTable.put(0, 33, new String("0--33"));
        personTable.put(1, 66, new String("1--66"));

        // 得到行集合
        Map<Integer, String> rowMap = personTable.row(0);
        System.out.println(rowMap);// {25=0--25, 33=0--33, 27=0--27,
        // 30=0--30}
        int maxAge = Collections.max(rowMap.keySet());
        // System.out.println(maxAge);// 33

        // 3.4 BiMap
        // 是一个一一映射，可以通过key得到value，也可以通过value得到key；
        BiMap<Integer, String> biMap = HashBiMap.create();
        biMap.put(1, "hello");
        biMap.put(2, "helloa");
        biMap.put(3, "world");
        biMap.put(4, "worldb");
        biMap.put(5, "my");
        biMap.put(6, "myc");

        int value = biMap.inverse().get("my");
        // System.out.println("my--" + value + ", " + value + "--"
        // + biMap.get(value));

		

		/*
         * Ordering<Person> byAge=new Ordering<Person>() {
		 * 
		 * @Override public int compare( Person left, Person right) { return
		 * right.getAge()-left.getAge(); } }; for(Person p:
		 * byAge.immutableSortedCopy(personList)) { System.out.println(p); } }
		 */
    }

}
