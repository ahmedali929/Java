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
			createStudent(studentDAO);
		};
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
