package Guava.basic;

import com.google.common.base.CharMatcher;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * 感觉CharMatcher其实就是为常见的需求提供了封装好的解决方案。
 *
 * @author Enbandari
 */
public class CharMatcherDemo {

    @Test
    public void main() {
        String tabsAndSpaces = "String with spaces and				tabs";
        String expected = "String with spaces and tabs";
        String scrubbed = CharMatcher.WHITESPACE.collapseFrom(tabsAndSpaces, ' ');
        assertEquals("结果有误", expected, scrubbed);

        String lettersAndNumbers = "foo989yxbar234";
        String expected2 = "989234";
        String retained = CharMatcher.JAVA_DIGIT.retainFrom(lettersAndNumbers);
        assertEquals("结果有误", expected2, retained);
    }

    @Test
    public void test() {
        // 以下表达式表示保留数字和-字符，其它都清掉   运行结果：-888-999082342

        assertEquals("计算有误", "-888-999082342", CharMatcher.DIGIT.or(CharMatcher.is('-')).retainFrom("abcdef-888-999*(*082342ab"));

        // 表示只保留字符串中的数字 运行结果：1065889998123
        String numOnly = CharMatcher.DIGIT.retainFrom("1065889998abcd123L");
        System.out.println(numOnly);

        // 以下表示匹配传参是否均小写 且均是英文字符
        boolean low = CharMatcher.JAVA_LOWER_CASE.matchesAllOf("abcd");
        System.out.println("全是英文且全小写:" + low);

        // 以下表示匹配传参是否均小写且允许是数字的 且均是英文字符
        low = CharMatcher.JAVA_LOWER_CASE.or(CharMatcher.DIGIT).matchesAllOf("abcd3233");
        System.out.println("只允许小写英文和数字:" + low);

        // 从表达式中匹配出所有英文字符  negate()表示取非(不允许)
        System.out.println(CharMatcher.JAVA_LETTER.retainFrom("abcdeABabCD989asdf/2323(*()*&(&"));
        String englistOnly = CharMatcher.JAVA_LETTER_OR_DIGIT.and(CharMatcher.DIGIT.negate()).retainFrom("abcdeABabCD989asdf/2323(*()*&(&");
        System.out.println("只允许英文字符：" + englistOnly);

        // 定义成常量以便别的地方调用 一般定义在全局变量中作为一个对像存在
        final CharMatcher SERIES_ID_CHARS = CharMatcher.DIGIT.or(CharMatcher.is('-'));

    }

}
