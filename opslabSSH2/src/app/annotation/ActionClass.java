package app.annotation;

import java.lang.annotation.*;

/**
 * <h6>Description:<h6>
 * <p>用来备注Action类用途的</p>
 *
 * @date 2015-06-10.
 */
@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ActionClass {
    String value();
}
