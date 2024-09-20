package org.generation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.generation.classes.Course;
import org.generation.classes.Student;

import org.generation.exceptions.CourseNotFoundException;
import org.generation.exceptions.StudentNotFoundException;

public class StudentService {
    private HashMap<String, Course> courseList = new HashMap<>();

    private HashMap<String, Student> students = new HashMap<>();

    private HashMap<String, List<Course>> coursesEnrolledByStudents = new HashMap<>();


    public StudentService() {
        courseList.put( "Math", new Course( "Math", 10, "Aurelio Baldor" ) );
        courseList.put( "Physics", new Course( "Physics", 10, "Albert Einstein" ) );
        courseList.put( "Art", new Course( "Art", 10, "Pablo Picasso" ) );
        courseList.put( "History", new Course( "History", 10, "Sima Qian" ) );
        courseList.put( "Biology", new Course( "Biology", 10, "Charles Darwin" ) );
    } // StudentService

// Ejercicio Parte 1
    public void addStudent(String id, Student student) {
    	this.students.put(id, student);
    } // addStudent
 // Ejercicio Parte 1
    
    public void enrollStudents( String courseName, String studentID ) throws CourseNotFoundException, StudentNotFoundException {
        Course course = courseList.get( courseName );

        if (course == null) {
        	throw new CourseNotFoundException();
        } // CourseNotFoundException
        Student student = students.get(studentID);
        if (student == null) {
            throw new StudentNotFoundException();
        } // StudentNotFoundException
        coursesEnrolledByStudents.put( studentID, new ArrayList<>() );
        coursesEnrolledByStudents.get( studentID ).add( course );
    } // enrollStudents

    public void unEnrollStudents( String courseName, String studentID ) throws CourseNotFoundException, StudentNotFoundException {
        Course course = courseList.get( courseName );
        
        if (course == null) {
        	throw new CourseNotFoundException();
        } // CourseNotFoundException
        Student student = students.get(studentID);
        if (student == null) {
            throw new StudentNotFoundException();
        } // StudentNotFoundException
        
        coursesEnrolledByStudents.get( studentID ).remove( course );
    } // unEnrollStudents

    public void showEnrolledStudents(String courseId){
        //TODO implement using collections loops
    	Course course = courseList.get(courseId);
    	Student student;
    	System.out.println("Students enrolled in the course " + course.getName() + ": ");
        
        for (String key : coursesEnrolledByStudents.keySet()) {
            	if (coursesEnrolledByStudents.get(key).contains(course)) {
            		student = students.get(key);
                    System.out.println(student);
            	} // if
        } // for
    } // showEnrolledStudents

    public void showAllCourses(){
        //TODO implement using collections loops
    	for (Course course : courseList.values()) {
            System.out.println(course);
        } // for
    } // showAllCourses
    
} // class StudentService