package app.exception;

/**
 * <h6>Description:<h6>
 * <p>业务层的异常</p>
 *
 * @date 2015-07-08.
 */
public class ServicesException extends RuntimeException{
    public ServicesException(String msg){
        super(msg);
    }

    public ServicesException(Throwable cause){
        super(cause);
    }

    public ServicesException(String msg,Throwable cause){
        super(cause);
    }
}
