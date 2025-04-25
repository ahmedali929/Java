package com.company.cruddemo;

import com.company.cruddemo.dao.StudentDao;
import com.company.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	//executed after spring beans have been loaded
	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);

			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDao studentDAO) {

		// create a student object
		System.out.println("Creating a new student object...");
		Student tempStudent = new Student("Son", "Goku", "goku@example.com");

		// save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// retrieve student based on the id: primary key
		System.out.println("Returning the student with the id: " + theId);
		Student returnedStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Here is the student: " + returnedStudent);

	}

	private void createMultipleStudents(StudentDao studentDAO) {

		// create multiple students
		System.out.println("Creating 3 new student objects ...");
		Student tempStudent1 = new Student("John", "Doe", "john@example.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@example.com");
		Student tempStudent3 = new Student("Taha", "Shah", "taha@example.com");

		// save the student object
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDao studentDAO) {
		// create the student object
		System.out.println("Creating a new student object ...");
		Student tempStudent = new Student("Paul", "Doe", "paul@example.com");

		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}




}
