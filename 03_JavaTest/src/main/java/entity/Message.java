package entity;

/**
 * Created by wuyanbing on 2017/8/16 0016.
 */
public class Message {
    public static final int HELLO = 0;

    public static final int GOODBYE = 1;


    private String message;

    private int status;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public int getStatus() {
        return this.status;
    }


    public void setStatus(int status) {
        this.status = status;
    }


}
