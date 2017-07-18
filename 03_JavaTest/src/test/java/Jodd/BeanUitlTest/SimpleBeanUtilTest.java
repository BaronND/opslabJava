package Jodd.BeanUitlTest;

import Jodd.model.Foo;
import jodd.bean.BeanUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <h6>Description:<h6>
 * <p>简单的BeanUtil</p>
 *
 * @date 2015-06-29.
 */
public class SimpleBeanUtilTest {

    @Test
    public void testBeanUtil() {
        Foo foo = new Foo();
        System.out.println(String.valueOf(BeanUtil.hasProperty(foo, "name")));
        assertEquals(String.class, BeanUtil.getPropertyType(foo, "readWrite"));
    }


    /**
     * 简单的BeanUtil测试
     * In BeanUtil world, bean property is a class field with its optional setter and getter
     * (aka accessors) methods. When accessing properties, BeanUtil first tries to use
     * accessors methods. If they don't exist, BeanUtil fail-backs to using the field of the
     * same visibility. Therefore, existence of accessors methods is not required and depends
     * on usage, what often may be handy. BeanUtil is used internally inside the Jodd library,
     * so this behavior applies everywhere.
     */
    @Test
    public void testSimpleBeanUtil() {
        Foo foo = new Foo();
        BeanUtil.setProperty(foo, "readWrite", "readWrite data");
        BeanUtil.setDeclaredProperty(foo, "readOnly", "readOnly data");
        System.out.println("属性设置" + foo);
        //获取属性
        System.out.println(BeanUtil.getProperty(foo, "readWrite"));
        System.out.println(BeanUtil.getProperty(foo, "readOnly"));
    }
}
