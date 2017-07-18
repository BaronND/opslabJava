package JavaSE.TryCatch;

public class HandleException {
    public static void main(String[] args) {
        int y = 10;
        int x = 0;
        int z;

        try {
            z = y / x;
            System.out.println("y/x=" + z);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("此处的带肯定会执行");
        }
    }
}
