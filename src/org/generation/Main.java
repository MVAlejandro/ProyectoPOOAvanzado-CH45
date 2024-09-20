package org.generation;

import org.generation.classes.Student;
import org.generation.exceptions.CourseNotFoundException;
import org.generation.exceptions.StudentNotFoundException;

public class Main {

    public static void main(String[] args) throws CourseNotFoundException, StudentNotFoundException {
	    StudentService studentService = new StudentService();
	    //TODO refactor this code to use encapsulation inside studentsService
	    studentService.addStudent( "1030", new Student( "Carlos", "1030", 31 ) );
        studentService.addStudent( "1040", new Student( "Ian", "1040", 28 ) );
        studentService.addStudent( "1050", new Student( "Elise", "1050", 26 ) );
        studentService.addStudent( "1020", new Student( "Santiago", "1020", 33 ) );

        System.out.println("----------------------------- Mostrar todos los cursos -----------------------------");
        studentService.showAllCourses();
        System.out.println("------------------------------------------------------------------------------------");
        
        // Intentar inscribir a un estudiante en un curso que no existe
        System.out.println("---------- Inscribir a un estudiante en un curso que no existe ----------");
        try {
            studentService.enrollStudents("Chemistry", "1030");
        } catch (CourseNotFoundException e) {
            System.out.println(e.getMessage());
        } catch(StudentNotFoundException e) {
        	System.out.println(e.getMessage());
        } // CourseNotFoundException
        System.out.println("------------------------------------------------------------------------------------");

        // Intentar inscribir a un estudiante que no existe
        System.out.println("--------------------- Inscribir a un estudiante que no existe ----------------------");
        try {
            studentService.enrollStudents("Math", "9999");
        } catch (CourseNotFoundException e) {
            System.out.println(e.getMessage());
        } catch(StudentNotFoundException e) {
        	System.out.println(e.getMessage());
        } // StudentNotFoundException
        System.out.println("------------------------------------------------------------------------------------");
        
        // Inscribir a un estudiante existente en un curso existente
        System.out.println("---------------------------- Inscribir a 1030 en Math ------------------------------");
        studentService.enrollStudents("Math", "1040");
        try {
            studentService.enrollStudents("Math", "1030");
            
        } catch (CourseNotFoundException e) {
            System.out.println(e.getMessage());
        } catch(StudentNotFoundException e) {
        	System.out.println(e.getMessage());
        } // enrollStudents
        
        System.out.println("-------------------- Mostrar los alumnos enlistados en el curso --------------------");
        studentService.showEnrolledStudents("Math");
        System.out.println("------------------------------------------------------------------------------------");
        
        // Intentar desinscribir a un estudiante en un curso que no existe
        System.out.println("-------------- Desinscribir a un estudiante en un curso que no existe --------------");
        try {
            studentService.unEnrollStudents("Chemistry", "1030");
        } catch (CourseNotFoundException e) {
            System.out.println(e.getMessage());
        } catch(StudentNotFoundException e) {
        	System.out.println(e.getMessage());
        } // CourseNotFoundException
        System.out.println("------------------------------------------------------------------------------------");

        // Intentar Desinscribir a un estudiante que no existe
        System.out.println("-------------------- Desinscribir a un estudiante que no existe --------------------");
        try {
            studentService.unEnrollStudents("Math", "9999");
        } catch (CourseNotFoundException e) {
            System.out.println(e.getMessage());
        } catch(StudentNotFoundException e) {
        	System.out.println(e.getMessage());
        } // StudentNotFoundException
        System.out.println("------------------------------------------------------------------------------------");
        
        // Desinscribir a un estudiante existente en un curso existente
        System.out.println("--------------------------- Desinscribir a 1030 en Math ----------------------------");
        try {
            studentService.unEnrollStudents("Math", "1030");
            
        } catch (CourseNotFoundException e) {
            System.out.println(e.getMessage());
        } catch(StudentNotFoundException e) {
        	System.out.println(e.getMessage());
        } // unEnrollStudents
        
        System.out.println("---------- Mostrar los alumnos enlistados en el curso luego de los cambios----------");
        studentService.showEnrolledStudents("Math");
        System.out.println("------------------------------------------------------------------------------------");
        
        
    } // main
    
} // class Main
