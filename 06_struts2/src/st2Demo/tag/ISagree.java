package st2Demo.tag;

public class ISagree {
	private boolean agree;

	public void setAgree(boolean agree) {
		this.agree = agree;
	}
	
	public boolean getAgree(){
		return agree;
	}


	@Override
	public String toString() {
		return "ISagree [agree=" + agree + "]";
	}

	public String isAgree(){
		System.out.println(this);
		return "input";
	}
}
