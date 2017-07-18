package cxfDemo.Spring.DAO;

public class order {
	private String	id;
	
	private String  name;
	
	private double  pricle;

	public order() {
	}

	public order(String id, String name, double pricle) {
		super();
		this.id = id;
		this.name = name;
		this.pricle = pricle;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPricle() {
		return pricle;
	}

	public void setPricle(double pricle) {
		this.pricle = pricle;
	}

	@Override
	public String toString() {
		return "order [id=" + id + ", name=" + name + ", pricle=" + pricle
				+ "]";
	}
	
	
}
