package JavaReflect.daynamicProxy;

public class ProductImpl implements Product {

    @Override
    public void save() {
        System.out.println("ProductTransactionImpl::save is called");
    }

}
