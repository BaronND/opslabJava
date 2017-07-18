package SpringSE.factory;

public class Product {
	
	private Long productId;
	
	private String productName;
	
	private Float price;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName="
				+ productName + ", price=" + price + "]";
	}

	public Product(Long productId, String productName, Float price) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}

	public Product() {
	}
	
	
}
