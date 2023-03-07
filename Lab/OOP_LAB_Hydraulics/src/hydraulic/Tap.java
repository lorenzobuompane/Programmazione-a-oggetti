package hydraulic;

/**
 * Represents a tap that can interrupt the flow.
 * 
 * The status of the tap is defined by the method
 * {@link #setOpen(boolean) setOpen()}.
 */

public class Tap extends Element {
	
	private double in_flow;
	private double out_flow;
	private boolean open;

	public Tap(String name) {
		super(name);
		//TODO: complete
	}
	
	/**
	 * Defines whether the tap is open or closed.
	 * 
	 * @param open  opening level
	 */
	public void setOpen(boolean open){
		if(open) {
			this.open=true;
		}
		else {
			this.open=false;
		}
		
	}
	
	@Override
	public void calculateFlow(double flow) {
		if (this.open) {
			this.in_flow = flow;
			this.out_flow = flow;
		}
		else {
			this.in_flow = flow;
			this.out_flow = 0.0;			//con NO_FLOW non mi vanno i test
		}
		this.output.calculateFlow(out_flow);
	}
	
	@Override
	public void getInfo(SimulationObserver observer) {
		observer.notifyFlow("Tap", super.getName(), this.in_flow, this.out_flow);
		if (this.output != null) {
			this.output.getInfo(observer);
		}
	}
	
	@Override
	public String printElement(int lenght) {
		String str;
		str = "[" + super.getName() + "]" + " Tap ->  ";
		lenght = lenght + str.length();
		str = str + this.output.printElement(lenght);
		return str;
	}
}


