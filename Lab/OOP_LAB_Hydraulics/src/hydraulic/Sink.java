package hydraulic;

/**
 * Represents the sink, i.e. the terminal element of a system
 *
 */
public class Sink extends Element {

	private double in_flow;
	
	/**
	 * Constructor
	 * @param name
	 */
	public Sink(String name) {
		super(name);
		//TODO: complete
	}
	
	@Override
	public void connect(Element elem){ 
		
	}
	
	@Override
	public Element getOutput(){
		//System.err.println("Elemento selezionato di tipo Sink: non presenta un output");
		return null;
	}
	
	@Override
	public void calculateFlow(double flow) {
		this.in_flow=flow;
	}
	
	@Override
	public void getInfo(SimulationObserver observer) {
		observer.notifyFlow("Sink", super.getName(), this.in_flow, SimulationObserver.NO_FLOW);
	}
	
	@Override
	public String printElement(int lenght) {
		String str;
		str = "[" + super.getName() + "]" + " Sink |";
		return str;
	}
}
