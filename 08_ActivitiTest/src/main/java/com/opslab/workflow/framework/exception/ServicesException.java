package com.opslab.workflow.framework.exception;

/**
 * <h6>Description:<h6>
 * <p>业务层的异常</p>
 *
 * @date 2015-07-08.
 */
public class ServicesException extends RuntimeException{
	
   
	private static final long serialVersionUID = 1114153877733473896L;

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
