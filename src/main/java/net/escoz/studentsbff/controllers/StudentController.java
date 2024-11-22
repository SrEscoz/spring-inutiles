package net.escoz.studentsbff.controllers;

import lombok.AllArgsConstructor;
import net.escoz.studentsbff.controllers.dtos.StudentOutDTO;
import net.escoz.studentsbff.mappers.StudentMapper;
import net.escoz.studentsbff.models.Student;
import net.escoz.studentsbff.serivices.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {

	private StudentService studentService;
	private StudentMapper studentMapper;

	@GetMapping
	public ResponseEntity<List<StudentOutDTO>> getAllStudents() {
		List<Student> students = studentService.getAllStudents();
		List<StudentOutDTO> response = students.stream()
				.map(studentMapper::toDTO)
				.toList();

		return ResponseEntity
				.ok()
				.body(response);
	}

}
