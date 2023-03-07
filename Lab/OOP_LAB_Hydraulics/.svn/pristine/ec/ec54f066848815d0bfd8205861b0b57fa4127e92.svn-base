package hydraulic;

/**
 * Represents a source of water, i.e. the initial element for the simulation.
 *
 * The status of the source is defined through the method
 * {@link #setFlow(double) setFlow()}.
 */
public class Source extends Element {
	
	private double out_flow;

	public Source(String name) {
		super(name);
		//TODO: complete
	}

	/**
	 * defines the flow produced by the source
	 * 
	 * @param flow
	 */
	public void setFlow(double flow) {
		this.out_flow = flow;
	}
	
//	@Override
//	public void calculateFlow(double flow) {
//		this.out_flow = flow;	
//	}
	
	@Override
	public void getInfo(SimulationObserver observer) {
		this.output.calculateFlow(out_flow);
		observer.notifyFlow("Source", super.getName(), SimulationObserver.NO_FLOW, this.out_flow);
		if (this.output != null) {
			this.output.getInfo(observer);
		}
	}
	
	@Override
	public String printElement(int lenght) {
		String str;
		str = "[" + super.getName() + "]" + " Source ->  ";
		lenght = lenght + str.length();
		str = str + this.output.printElement(lenght);
		return str;
	}
}
