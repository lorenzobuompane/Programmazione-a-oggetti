package mountainhuts;

public class Altitude {

	private Integer min;
	private Integer max;
	
	public Altitude (Integer min, Integer max) {
		this.setMin(min);
		this.setMax(max);
	}
	
	public boolean isHere(Integer altitude) {
		if ((altitude) >= (min) && (altitude) <= (max)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String getStringRange() {
		return getMin() + "-" + getMax();
	}
	
	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}
}
