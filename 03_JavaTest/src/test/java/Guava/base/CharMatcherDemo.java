package Guava.base;

import com.google.common.base.CharMatcher;
import org.junit.Test;

/**
 * 感觉CharMatcher其实就是为常见的需求提供了封装好的解决方案。
 */
public class CharMatcherDemo {
    @Test
    public void test() {
        String tabsAndSpaces = "String with spaces and				tabs";
        String expected = "String with spaces and tabs";
        String scrubbed = CharMatcher.WHITESPACE.collapseFrom(tabsAndSpaces, ' ');
        System.out.println(expected.equals(scrubbed));

        String lettersAndNumbers = "foo989yxbar234";
        String expected2 = "989234";
        String retained = CharMatcher.JAVA_DIGIT.retainFrom(lettersAndNumbers);
        System.out.println(retained);
    }
}
