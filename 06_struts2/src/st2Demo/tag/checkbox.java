package st2Demo.tag;

public class checkbox{
	private String lanuageId;
	private String langageName;
	
	public String getLanuageId() {
		return lanuageId;
	}
	public void setLanuageId(String lanuageId) {
		this.lanuageId = lanuageId;
	}
	public String getLangageName() {
		return langageName;
	}
	public void setLangageName(String langageName) {
		this.langageName = langageName;
	}
	@Override
	public String toString() {
		return "checkbox [lanuageId=" + lanuageId + ", langageName=" + langageName + "]";
	}
	public checkbox(String lanuageId, String langageName) {
		super();
		this.lanuageId = lanuageId;
		this.langageName = langageName;
	}
	public checkbox() {
		super();
	}
}