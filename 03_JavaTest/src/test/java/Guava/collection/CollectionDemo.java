package Guava.collection;

import com.google.common.collect.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Guava中提供collection相关的操作
 */
public class CollectionDemo {

    @Test
    public void testCreateCollection() {
        //创建集合
        List<String> list = Lists.newArrayList();
        List<Map<String, String>> list2 = Lists.newArrayList();
        List<String> linkedList = Lists.newLinkedList();
        System.out.println(Lists.newArrayList());
        System.out.println(Lists.newArrayList(1, 2, 3));
        System.out.println(Lists.newArrayList(Sets.newHashSet(1, 2, 3)));
        System.out.println(Lists.newArrayListWithCapacity(10));
        System.out.println(Lists.newArrayListWithExpectedSize(10));
        System.out.println(Lists.newLinkedList());
        System.out.println(Lists.newLinkedList(Sets.newHashSet(1, 2, 3)));
        System.out.println(Lists.partition(Lists.newArrayList(1, 2, 3, 4, 5), 2));
        System.out.println(Lists.reverse(Lists.newArrayList(1, 2, 3, 4, 5)));
        Set<String> Set = Sets.newHashSet();
        Map<String, String> map2 = Maps.newHashMap();
        Map<String, Map<String, String>> map = Maps.newHashMap();

        Integer[] intArrays = ObjectArrays.newArray(Integer.class, 10);
    }

    @Test
    public void testMap() {
        //以下Map是可操作 及可以修改其值
        HashMap<String, Integer> map1 = Maps.newHashMap(ImmutableMap.of("John", 100));
        map1.get("John");
        map1.put("John", 1000);

        //以下map只能做读操作不能进行写操作Immutable的意思是不可变的
        Map<String, Integer> map = ImmutableMap.<String, Integer>builder()
                .put("John", 1000)
                .put("Jane", 1500)
                .put("Adam", 2000)
                .put("Tom", 2000)
                .build();

        map.get("John");
    }

    @Test
    public void testSets() {
        // 静态工厂方法
        Sets.newHashSet();
        Sets.newHashSet(1, 2, 3);
        Sets.newHashSetWithExpectedSize(10);
        Sets.newHashSet(Lists.newArrayList(1, 2, 3));

        Sets.newLinkedHashSet();
        Sets.newLinkedHashSetWithExpectedSize(10);
        Sets.newLinkedHashSet(Lists.newArrayList(1, 2, 3));

        Sets.newTreeSet();
        Sets.newTreeSet(Lists.newArrayList(1, 2, 3));
        Sets.newTreeSet(Ordering.natural());

        // 集合运算(返回SetView)
        Sets.union(Sets.newHashSet(1, 2, 3), Sets.newHashSet(4, 5, 6)).toString(); // 取并集[1,2,3,4,5]
        Sets.intersection(Sets.newHashSet(1, 2, 3), Sets.newHashSet(3, 4, 5)); // 取交集[3]
        Sets.difference(Sets.newHashSet(1, 2, 3), Sets.newHashSet(3, 4, 5)); // 只在set1, 不在set2[1,2]
        Sets.symmetricDifference(Sets.newHashSet(1, 2, 3), Sets.newHashSet(3, 4, 5)); // 交集取反[1,2,4,5]

        // 其他工具方法
        Sets.cartesianProduct(Lists.newArrayList(Sets.newHashSet(1, 2), Sets.newHashSet(3, 4))); // 返回所有集合的笛卡尔积
        Sets.powerSet(Sets.newHashSet(1, 2, 3)); // 返回给定集合的所有子集
    }

}
