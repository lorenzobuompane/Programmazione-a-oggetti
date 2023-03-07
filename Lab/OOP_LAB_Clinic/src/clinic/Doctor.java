package clinic;

import java.util.ArrayList;

public class Doctor extends Patient{
	
	private int docID;
	private String specialization;
	private ArrayList<Patient> pat;
	
	public Doctor (String first, String last, String ssn, int docID, String specialization) {
		super(first, last, ssn);
		this.docID=docID;
		this.specialization=specialization;
		this.setPat(new ArrayList<>());
	}

	public int getId() {
		return docID;
	}

	public void setId(int docID) {
		this.docID= docID;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public ArrayList<Patient> getPat() {
		return pat;
	}

	public void setPat(ArrayList<Patient> pat) {
		this.pat = pat;
	}
	
	public void addPatient(Patient p) {
		this.pat.add(p);
	}
	
	public String getLastFirst() {
		return getLast() + " " + getFirst();
	}
	
	public int getnPatient() {
		return this.pat.size();
	}
	
	public String stringNumPatient() {
		String num = String.format("%3d", getnPatient());
		return num + " : " + this.docID + " " + getLast() + " " + getFirst();
	}

}
