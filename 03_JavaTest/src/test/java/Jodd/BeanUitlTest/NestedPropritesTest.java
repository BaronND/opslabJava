package Jodd.BeanUitlTest;

import Jodd.model.Foo;
import com.google.common.collect.Lists;
import jodd.bean.BeanUtil;
import org.junit.Test;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试嵌套属性
 */
public class NestedPropritesTest {

    /**
     * 数组和列表可以直接通过下标获取和设置相应的属性
     */
    @Test
    public void testNestProprites() {
        List<Foo> list = Lists.newArrayList(new Foo(), new Foo());
        BeanUtil.setProperty(list, "[0].readWrite", "AA");
        BeanUtil.setDeclaredPropertySilent(list, "[0].readOnly", "BB");
        BeanUtil.setProperty(list, "[1].readWrite", "AAA");
        BeanUtil.setDeclaredPropertySilent(list, "[1].readOnly", "BBB");
        System.out.println(list);
        System.out.println((String) BeanUtil.getProperty(list, "[0].readWrite"));

    }


    /**
     * map是键值对的数据结构所以需要使用[key]的方式访问
     */
    @Test
    public void testNestPropritesMap() {
        Map<String, Foo> map = new HashMap<String, Foo>();
        map.put("foo1", new Foo());
        map.put("foo2", new Foo());

        BeanUtil.setProperty(map, "[foo1].readWrite", "AA");
        BeanUtil.setDeclaredProperty(map, "[foo1].readOnly", "BB");
        BeanUtil.setProperty(map, "[foo2].readWrite", "AAA");
        BeanUtil.setDeclaredProperty(map, "[foo2].readOnly", "BBB");
        System.out.println(map);

    }
}
