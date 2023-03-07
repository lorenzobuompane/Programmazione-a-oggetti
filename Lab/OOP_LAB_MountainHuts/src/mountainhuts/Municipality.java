package mountainhuts;

public class Municipality {
	
	private String name;
	private String province;
	private Integer altitude;
	private int nHut;
	
	public Municipality (String name, String province, Integer altitude) {
		this.name=name;
		this.province=province;
		this.altitude=altitude;
		this.nHut=0;
	}

	public void increaseHut() {
		this.nHut++;
	}
	
	public String getName() {
		return this.name;
	}

	public String getProvince() {
		return this.province;
	}

	public Integer getAltitude() {
		return this.altitude;
	}

	public long getnHut() {
		return (long) nHut;
	}

}
