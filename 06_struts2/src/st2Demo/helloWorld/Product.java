package st2Demo.helloWorld;

public class Product {
	private String productId;
	
	private String productName;
	
	private String productDes;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDes() {
		return productDes;
	}

	public void setProductDes(String productDes) {
		this.productDes = productDes;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName="
				+ productName + ", productDes=" + productDes + "]";
	}
	
	public String save(){
		System.out.println("Action save:"+this);
		return "success";
	}
	
}
