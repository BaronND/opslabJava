package app.exception;

/**
 * <h6>Description:<h6>
 * <p>
 *     数据持久话层的异常实体类，数据持久化层的方法因将所有数据持久化相关的所有异常包装成该类型的异常
 *     并抛像上层调用。除此之外的所有异常都因在数据持久化层进行自我消化
 *
 *     另外DataAccessException异常也可以理解为一种特殊的ServicesException异常
 * </p>
 *
 */
public class DataAccessException extends ServicesException {

    public DataAccessException(String msg){
        super(msg);
    }

    public DataAccessException(String msg,Throwable cause){
        super(msg,cause);
    }

    public DataAccessException(Throwable cause){
        super(cause);
    }
}
