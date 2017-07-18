package JavaSE.oop.Interface;

/******************************************
 *
 * @summary 演示继承一个接口并实现相应的方法
 ******************************************/
public class ExtendsInterface implements DefineInterface {

    @Override
    public String getInfo() {
        return "it's ExtendsInterface";
    }


    public static void main(String[] args) {
        ExtendsInterface obj = new ExtendsInterface();

        System.out.println(obj.getInfo());
    }
}
