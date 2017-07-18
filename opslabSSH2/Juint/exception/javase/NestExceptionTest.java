package exception.javase;

/**
 * <h6>Description:<h6>
 * <p>测试异常的嵌套</p>
 *
 * @date 2015-07-08.
 */
public class NestExceptionTest {
    public static void main(String[] args) {
        try {
            methodB();
        } catch (Exception exception) {
            System.out.println("异常信息:"+exception.getMessage());
            //exception.printStackTrace();
        }
        System.out.println("execute after exception occurs!");
    }

    public static void methodB() throws ExceptionB {
        System.out.println("MethodB is call");
        //此处如果直接将异常处理了MethodB能正常执行，但结果未必就是想要的
        //如果将异常ExceptionA直接抛出则会修改methodB的方法签名
        //所谓为ExceptionB异常类定义封装ExceptionA的方法是一周不失优雅方式
        try {
            methodA();
        }catch (ExceptionA ex){
            //直接处理异常
            //ex.printStackTrace();

            //将异常ExceptionA封装成ExceptionB在向上抛出
            throw new ExceptionB(ex);
        }
    }

    public static void methodA() throws ExceptionA {
        System.out.println("MethodA is call");
        throw new ExceptionA("An exception occurs in MethodA");
    }
}
