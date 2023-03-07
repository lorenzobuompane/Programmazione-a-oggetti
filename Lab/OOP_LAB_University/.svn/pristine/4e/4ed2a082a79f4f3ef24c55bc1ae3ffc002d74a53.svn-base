package university;

public class Course {
	
	//ATTRIBUTI
	private String title;			//titolo corso
	private String teacher;			//insegnante corso
	private int code = 10;			//codice (parte da 10)
	private int nAttendees = 0;		//numero studenti iscritti
	
	private Student[] attendees = new Student [MAX_STUDxINS];			//iscritti al corso
	
	//COSTANTI
	static final int MAX_STUDxINS = 100;		//numero massimo di studenti per ciascun insegnamento
	
	//CTOR
	public Course (String title, String teacher, int code) {
		this.title = title;
		this.teacher = teacher;
		this.code += code;
		}

	//METODI
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public int getCode() {
		return code;
	}

	public int getnAttendees() {
		return nAttendees;
	}
	
	/**
	 * Control student
	 * 
	 * TRUE: can register
	 * FALSE: can't register
	 * 
	 * @param student ID
	 * @return boolean
	 */
	public Boolean ctrlStud (int studentID) {
		int i;
		for (i=0; i<MAX_STUDxINS; i++) {
			if (attendees[i].getMatr() != studentID) {
				if (nAttendees!=MAX_STUDxINS) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Register student
	 * 
	 * @param student
	 */
	public void regStud (Student student) {
		int i;
		for (i=0; i<MAX_STUDxINS; i++) {
			if (attendees[i]==null) {
				attendees[i]=student;
				nAttendees++;
				break;
			}

		}
	}
	
	/**
	 * Creation string with student 
	 * @return
	 */
	public String risStringa() {
		int i;
		String risultato = "";
		for (i=0; i<nAttendees; i++) {
			risultato = risultato + attendees[i].getMatr() + " " + attendees[i].getFirst() + " " + attendees[i].getLast() + "\n";
		}
		return risultato;
	}

	
	
}
