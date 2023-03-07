package hydraulic;

/**
 * Represents a split element, a.k.a. T element
 * 
 * During the simulation each downstream element will
 * receive a stream that is half the input stream of the split.
 */

public class Split extends Element {

	static final int MAX_OUTPUTS = 2;
	private Element[] output = new Element[MAX_OUTPUTS];
	
	private double in_flow;
	private double out_flow;
	
	/**
	 * Constructor
	 * @param name
	 */
	public Split(String name) {
		super(name);
		//TODO: complete
	}
    
	/**
	 * returns the downstream elements
	 * @return array containing the two downstream element
	 */
    public Element[] getOutputs(){
        return output;
    }

    /**
     * connect one of the outputs of this split to a
     * downstream component.
     * 
     * @param elem  the element to be connected downstream
     * @param noutput the output number to be used to connect the element
     */
	public void connect(Element elem, int noutput){
		this.output[noutput]=elem;
	}
	
	@Override
	public void calculateFlow(double flow) {
		if (this.output[0] != null && this.output[1] != null) {
			this.in_flow=flow;
			this.out_flow=flow/2;
			this.output[0].calculateFlow(out_flow);
			this.output[1].calculateFlow(out_flow);
		}
		else
			System.err.println("Split non valido: uno o due tubi a T non presentano un output!");
	}
	
	@Override
	public void getInfo(SimulationObserver observer) {
		observer.notifyFlow("Split", super.getName(), this.in_flow, this.out_flow);
		if (this.output[0] != null && this.output[1] != null) {
			this.output[0].getInfo(observer);
			this.output[1].getInfo(observer);
		}
	}
	
	@Override
	public String printElement(int lenght) {
		String str;
		int splitLenght;
		str = "[" + super.getName() + "]" + " Split ";
		splitLenght = lenght + str.length();
		str = str + "+->  ";
		lenght = lenght + str.length();
		str = str + this.output[0].printElement(lenght);
		str = str +"\n";
		for (int i=0; i<splitLenght; i++) {
			str = str + " ";
		}
		str = str +"|\n";
		for (int i=0; i<splitLenght; i++) {
			str = str + " ";
		}
		str = str + "+->  ";
		lenght = lenght + str.length();
		str = str + this.output[1].printElement(lenght);
		return str;
	}
}
