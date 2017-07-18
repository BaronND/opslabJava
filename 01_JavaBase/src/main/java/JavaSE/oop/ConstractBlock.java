package JavaSE.oop;

/**************************************************
 * @summary 演示类中构造块的定义 构造快在构造方法执行前调用
 *************************************************/
@SuppressWarnings("unused")
public class ConstractBlock {

    public String name = null;

    public String motto = null;

    {// 构造块定义
        this.name = "snake";
        this.motto = " Open Your's idea";
        System.out.println("Block.....");
    }

    public ConstractBlock() {
        System.out.println("Constract....");
        System.out.print(this.name + " say " + this.motto);
    }

    public static void main(String[] args) {

        ConstractBlock obj = new ConstractBlock();
    }
}
