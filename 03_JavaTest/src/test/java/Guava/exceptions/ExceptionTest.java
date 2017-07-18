package Guava.exceptions;

import com.google.common.base.Throwables;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

public class ExceptionTest {
    @Test
    @Ignore
    public void testExceptionToString() {
        try {
            throw new RuntimeException("RuntimeException-test");
        } catch (Exception e) {
            String ss = Throwables.getStackTraceAsString(e);
            System.out.println("程序抛出异常:" + ss);
        }
    }

    @Test
    @Ignore
    public void testExceptionCausalChain() {
        try {
            throw new RuntimeException("RuntimeException-test");
        } catch (Exception e) {
            List<Throwable> chain = Throwables.getCausalChain(e);
            for (Throwable t : chain) {
                System.out.println("程序抛出异常:" + String.valueOf(t));
            }
            e.printStackTrace();
        }
    }
}
