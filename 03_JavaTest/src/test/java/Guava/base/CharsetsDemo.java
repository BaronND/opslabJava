package Guava.base;

import com.google.common.base.Charsets;
import org.junit.Test;

public class CharsetsDemo {

    @Test
    public void test() {
        String something = "something";
        byte[] bytes = something.getBytes(Charsets.UTF_8);
    }
}
