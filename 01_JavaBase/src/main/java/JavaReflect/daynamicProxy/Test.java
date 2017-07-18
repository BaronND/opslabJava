package JavaReflect.daynamicProxy;

public class Test {
    public static void main(String[] args) {
        ProductImpl productImpl = new ProductImpl();

        Product product = ProductProxy.newInstance(productImpl);

        product.save();
    }
}
