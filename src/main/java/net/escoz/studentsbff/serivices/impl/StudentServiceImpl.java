package net.escoz.studentsbff.serivices.impl;

import lombok.AllArgsConstructor;
import net.escoz.studentsbff.controllers.dtos.PatchStudentDTO;
import net.escoz.studentsbff.controllers.dtos.StudentInDTO;
import net.escoz.studentsbff.mappers.StudentMapper;
import net.escoz.studentsbff.models.Student;
import net.escoz.studentsbff.repositories.StudentRepository;
import net.escoz.studentsbff.serivices.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;
	private StudentMapper studentMapper;

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudent(long id) {
		return studentRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	public Student addStudent(Student student) {

		studentRepository.findStudentByName(student.getName())
				.ifPresent(s -> {
					throw new ResponseStatusException(HttpStatus.CONFLICT);
				});

		studentRepository.findStudentByEmail(student.getEmail())
				.ifPresent(s -> {
					throw new ResponseStatusException(HttpStatus.CONFLICT);
				});

		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(StudentInDTO student, long id) {
		return studentRepository.save(studentMapper.update(getStudent(id), student));
	}

	@Override
	public Student patchMapping(PatchStudentDTO studentDTO, long id) {
		return studentRepository.save(studentMapper.patch(getStudent(id), studentDTO));
	}

	@Override
	public void deleteStudent(long id) {
		studentRepository.delete(getStudent(id));
	}
}
