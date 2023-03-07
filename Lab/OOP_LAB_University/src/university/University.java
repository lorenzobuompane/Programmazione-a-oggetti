package university;

import university.Student;

/**
 * This class represents a university education system.
 * 
 * It manages students and courses.
 *
 */

public class University {
	
	//Attributi
	private String name;		//name ateneo
	
	private String Rfirst;		//first name rettore
	private String Rlast;		//last name rettore	

	private Student[] student = new Student [MAX_STUD];		//vettore di studenti iscritti all'ateneo
	private Course[] course = new Course [MAX_INS];			//vettore degli insegnamenti disponibili nell'ateneo
	
	
	//Costanti
	static final int MAX_STUD = 1000;		//massimo studenti per ateneo
	static final int MAX_INS = 50;			//massimo insegnamenti per ateneo
	static final int CODE = 10;				//codice di partenza corsi
	static final int MATR = 10000;			//codice di partenza studenti
	
	/**
	 * Constructor
	 * 
	 * Insert university's name
	 * 
	 * @param name of the university
	 */
	public University(String name){
		this.name = name;
	}
	
	/**
	 * Getter for the name of the university
	 * 
	 * Return university's name
	 * 
	 * @return name of university
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Defines the rector for the university
	 * 
	 * Insert rector's first and last name
	 * 
	 * @param first
	 * @param last
	 */
	public void setRector(String first, String last){
		this.Rfirst = first;
		this.Rlast = last;
	}
	
	/**
	 * Retrieves the rector of the university
	 * 
	 * @return String = rector first name + rector last name
	 */
	public String getRector(){
		return (Rfirst + " " + Rlast);
	}
	
	/**
	 * Enroll a student in the university
	 * 
	 * @param first name of the student
	 * @param last name of the student
	 * @return student ID
	 */
	public int enroll(String first, String last) {
		
		int i;
		for (i=0; i<MAX_STUD; i++) {
			if (student[i] == null) {
				student[i] = new Student(first, last, i);
				break;
			}
		}
		
		return student[i].getMatr();
		
	}
	
	/**
	 * Retrieves the information for a given student
	 * 
	 * @param student ID
	 * @return information about the student
	 */
	public String student(int id){
		
		int i;
		String retStudent = "Nessuno studente trovato";
		for (i=0; i<MAX_STUD; i++) {
			if (student[i].getMatr() == id) {
				retStudent = (Integer.toString(student[i].getMatr()) + " " + student[i].getFirst() + " " + student[i].getLast());
				break;
			}
		}
		return retStudent;
	}
	
	/**
	 * Activates a new course with the given teacher
	 * 
	 * @param course title
	 * @param teacher name of the course
	 * @return the unique code assigned to the course
	 */
	public int activate(String title, String teacher){
		
		int i;
		for (i=0; i<MAX_INS; i++) {
			if (course[i] == null) {
				course[i] = new Course(title, teacher, i);
				break;
			}
		}		
		return course[i].getCode();
	}
	
	/**
	 * Retrieve the information for a given course
	 * 
	 * @param unique code of the course
	 * @return information about the course
	 */
	public String course(int code){
		
		int i;
		String retCourse = "Nessun insegnamento trovato";
		for (i=0; i<MAX_INS; i++) {
			if (course[i].getCode() == code) {
				retCourse = (Integer.toString(course[i].getCode()) + ", " + course[i].getTitle() + ", " + course[i].getTeacher());
				break;
			}
		}
		return retCourse;
	}
	
	/**
	 * Register a student to attend a course
	 * 
	 * @param student ID
	 * @param course Code 
	 */
	public void register(int studentID, int courseCode){
		
		int i = studentID-MATR;
		int j = courseCode-CODE;
		
		if(student[i].ctrlIns(studentID, courseCode)==true) {
			student[i].regIns(course[j]);
			course[j].regStud(student[i]);
			//System.out.println("Studente " + student[i].getMatr() + " iscritto al corso " + course[j].getCode());
		}
	}

	
	/**
	 * Retrieve a list of attendees
	 * 
	 * @param courseCode
	 * @return list of attendees separated by "\n"
	 */
	public String listAttendees(int courseCode){
		return course[courseCode-CODE].risStringa();		
	}

	/**
	 * Retrieves the study plan for a student
	 * 
	 * @param student ID
	 * @return list of courses the student is registered for
	 */
	public String studyPlan(int studentID){
		return student[studentID-MATR].risString();
	}
}
