package Guava.Ordering;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

import java.util.Comparator;
import java.util.List;

/**
 * <h6>Description:<h6>
 * <p></p>
 *
 * @date 2015-06-18.
 */
public class OrderingTest {
    @org.junit.Test
    public void test() {
        List<String> list = Lists.newArrayList("22", "a", "bb", "11", "ccc");
        // Ordering.natural()-------对可排序类型做自然排序，如数字按大小，日期按先后排序
        list = Ordering.natural().sortedCopy(list);
        System.out.println(list);// [11, 22, a, bb, ccc]

        // Ordering.usingToString()------按对象的字符串形式做字典排序
        list = Ordering.usingToString().sortedCopy(list);
        System.out.println(list);// [11, 22, a, bb, ccc]

        // Ordering.from(comparator)-------把给定的Comparator转化为排序器
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // TODO Auto-generated method stub
                return o1.hashCode() - o2.hashCode();
            }
        };
        list = Ordering.from(comparator).sortedCopy(list);
        System.out.println(list);// [a, 11, 22, bb, ccc]

        // 实现自定义的排序器时，除了用上面的from方法，也可以跳过实现Comparator，而直接继承Ordering：
        Ordering<String> byLenOrdering = new Ordering<String>() {
            public int compare(String left, String right) {
                return Ints.compare(left.length(), right.length());
            }
        };

        list = byLenOrdering.sortedCopy(list);
        System.out.println(list);// [a, 11, 22, bb, ccc]

        // 链式调用方法：通过链式调用，可以由给定的排序器衍生出其它排序器
        // 1.reverse()-----获取语义相反的排序器
        // 2.nullsFirst()-----使用当前排序器，但额外把null值排到最前面
        // 3.nullsLast()-----使用当前排序器，但额外把null值排到最后面
        // 4.compound(Comparator)-----合成另一个比较器，以处理当前排序器中的相等情况
        // -------用compound方法包装排序器时，就不应遵循从后往前读的原则。
        // -------为了避免理解上的混乱，请不要把compound写在一长串链式调用的中间，你可以另起一行，在链中最先或最后调用compound。
        // 5.lexicographical()-----基于处理类型T的排序器，返回该类型的可迭代对象Iterable<T>的排序器
        // 6.onResultOf(Function)-----对集合中元素调用Function，再按返回值用当前排序器排序
        list = byLenOrdering.reverse().sortedCopy(list);
        System.out.println(list);// [ccc, 11, 22, bb, a]
    }
}
