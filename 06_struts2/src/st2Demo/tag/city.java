package st2Demo.tag;

public class city {
	private String cityId;
	
	private String cityName;

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "city [cityId=" + cityId + ", cityName=" + cityName + "]";
	}

	public city(String cityId, String cityName) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
	}

	public city() {
		super();
	}
	
	
}
