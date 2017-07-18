package JavaSE.Threads;

import org.junit.Test;

import java.util.Map;

/**
 * ��ӡ��ǰ�̵߳ĵ���ջ
 */
public class CallStack {
    @Test
    public void testPrintStack() {
        test();
    }

    public static void test() {
        /**
         * ��ӡ��ǰ�����ĵ�����
         */
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            String method = stackTraceElement.getMethodName();
            System.out.println(className + "::" + method);
        }
    }

    @Test
    public void testPrintStack1() {
        test1();
    }

    public static void test1() {
        /**
         * ��ӡ��ǰ�����ĵ�����
         */
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {

            System.out.println(stackTraceElement);
        }
    }


}
