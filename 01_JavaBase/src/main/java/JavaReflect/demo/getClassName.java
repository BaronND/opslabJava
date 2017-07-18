package JavaReflect.demo;

class x {

}

public class getClassName {


    public static void main(String[] args) {
        x i = new x();

        //通过i对象获取x类的相关信息
        String name = null;
        name = ((Object) i).getClass().getName();

        System.out.println(name);
    }

}
