package com.localowl.crud_demo;

import com.localowl.crud_demo.dao.StudentDAO;
import com.localowl.crud_demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			//createStudent(studentDAO);
			//readStudent(studentDAO);
			//readAllStudent(studentDAO);
			queryStudentsByLastName(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO){
		//create the student
		Student student = new Student("Merve", "Keser", "merve@localowl.com");

		//save the student
		studentDAO.save(student);

		//display id of the saved student
		System.out.println("Student Generated Id: " + student.getId());
	}

	private void readStudent(StudentDAO studentDAO){
		//create the student object
		Student student = new Student("Fatma", "Önal", "fatma@localowl.com");
		//save the student
		studentDAO.save(student);

		Student theStudent = studentDAO.findById(student.getId());
		System.out.println(theStudent);
	}

	private void readAllStudent(StudentDAO studentDAO){
		List<Student> allStudents = studentDAO.findAll();
		for(Student student: allStudents){
			System.out.println(student);
		}

	}

	private void queryStudentsByLastName(StudentDAO studentDAO){
		//get a list of students
		List<Student> students = studentDAO.findByLastName("Önal");

		for(Student student: students){
			System.out.println(student);
		}
	}

}
