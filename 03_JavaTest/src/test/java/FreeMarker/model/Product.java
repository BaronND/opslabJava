package FreeMarker.model;


/**
 * <h6>Description:<h6>
 * <p>用户测试Freemaker的数据模型</p>
 */
public class Product {
    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Product() {
    }

    public Product(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
