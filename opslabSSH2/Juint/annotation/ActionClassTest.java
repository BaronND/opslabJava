package annotation;

import app.annotation.ActionClass;
import org.junit.Test;

/**
 * <h6>Description:<h6>
 * <p></p>
 *
 * @date 2015-06-10.
 */
public class ActionClassTest {

    @Test
    public void testActionClass() throws ClassNotFoundException {
        Class anClass = Class.forName("app.struts.action.BusinessLogAction");
        boolean flag = anClass.isAnnotationPresent(ActionClass.class);
        if(flag){
            ActionClass ann = (ActionClass) anClass.getAnnotation(ActionClass.class);
            System.out.println("注解:"+ann.value());
        }
    }
}
