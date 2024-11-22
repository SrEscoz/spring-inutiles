package net.escoz.studentsbff.serivices;

import net.escoz.studentsbff.models.Student;

import java.util.List;

public interface StudentService {

	List<Student> getAllStudents();

	Student getstudent(int id);

	Student addStudent(Student student);

	Student updateStudent(Student student);

	void deleteStudent(int id);
}
