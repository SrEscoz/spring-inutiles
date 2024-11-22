package net.escoz.studentsbff.serivices.impl;

import lombok.AllArgsConstructor;
import net.escoz.studentsbff.models.Student;
import net.escoz.studentsbff.repositories.StudentRepository;
import net.escoz.studentsbff.serivices.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getstudent(int id) {
		return null;
	}

	@Override
	public Student addStudent(Student student) {
		return null;
	}

	@Override
	public Student updateStudent(Student student) {
		return null;
	}

	@Override
	public void deleteStudent(int id) {

	}
}
