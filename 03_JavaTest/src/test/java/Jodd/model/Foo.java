package Jodd.model;


/**
 * 用户测试Jodd的实体
 *
 * @date 2015-06-29.
 */
public class Foo {

    private String readWrite;

    private String readOnly;

    public String getReadWrite() {
        return readWrite;
    }

    public void setReadWrite(String readWrite) {
        this.readWrite = readWrite;
    }

    public String getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(String readOnly) {
        this.readOnly = readOnly;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "readWrite='" + readWrite + '\'' +
                ", readOnly='" + readOnly + '\'' +
                '}';
    }
}
