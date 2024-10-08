package org.generation.classes;

public class Course {
    private String name;
    private int credits;
    private String professorName;

    public Course( String name, int credits, String professorName ) {
        this.name = name;
        this.credits = credits;
        this.professorName = professorName;
    } // Constructor Course

    
	public String getName() {
		return name;
	} // getName

	public void setName(String name) {
		this.name = name;
	} // setName

	public int getCredits() {
		return credits;
	} // getCredits

	public void setCredits(int credits) {
		this.credits = credits;
	} // setCredits

	public String getProfessorName() {
		return professorName;
	} // getProfessorName

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	} // setProfessorName


	@Override
	public String toString() {
		return "Course [ Name= " + name + ", Credits= " + credits + ", Professor= " + professorName + " ]";
	}
    
    
} // class Course
