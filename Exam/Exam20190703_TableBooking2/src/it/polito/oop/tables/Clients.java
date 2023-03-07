package it.polito.oop.tables;

public class Clients {
	
	private int code;
	private String name;
	private int count;
	private String mobile;
	private boolean eated = false;
	
	public Clients(String name, int count, String mobile) {
		this.name=name;
		this.count=count;
		this.mobile=mobile;
	}

	public String getName() {
		return name;
	}

	public int getCount() {
		return count;
	}

	public String getMobile() {
		return mobile;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isEated() {
		return eated;
	}

	public void setEated(boolean eated) {
		this.eated = eated;
	}

}
