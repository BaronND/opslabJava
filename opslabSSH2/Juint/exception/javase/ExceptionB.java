package exception.javase;

/**
 * <h6>Description:<h6>
 * <p></p>
 *
 * @date 2015-07-08.
 */
public class ExceptionB extends Exception {
    public ExceptionB(String msg){
        super(msg);
    }

    public ExceptionB(Exception ex){
        super(ex);
    }
}
