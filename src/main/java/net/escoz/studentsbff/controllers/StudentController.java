package net.escoz.studentsbff.controllers;

import lombok.AllArgsConstructor;
import net.escoz.studentsbff.controllers.dtos.BasicDTO;
import net.escoz.studentsbff.controllers.dtos.PatchStudentDTO;
import net.escoz.studentsbff.controllers.dtos.StudentInDTO;
import net.escoz.studentsbff.controllers.dtos.StudentOutDTO;
import net.escoz.studentsbff.mappers.StudentMapper;
import net.escoz.studentsbff.models.Student;
import net.escoz.studentsbff.serivices.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {

	private StudentService studentService;
	private StudentMapper studentMapper;

	@GetMapping
	public ResponseEntity<List<StudentOutDTO>> getAllStudents() {
		return ResponseEntity
				.ok()
				.body(studentMapper.toDTOs(studentService.getAllStudents()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<StudentOutDTO> getStudent(@PathVariable long id) {
		return ResponseEntity
				.ok()
				.body(studentMapper.toDTO(studentService.getStudent(id)));
	}

	@PostMapping
	public ResponseEntity<StudentOutDTO> postStudent(@RequestBody StudentInDTO studentRequest) {
		Student student = studentMapper.toModel(studentRequest);

		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(studentMapper.toDTO(studentService.addStudent(student)));
	}

	@PutMapping("/{id}")
	public ResponseEntity<StudentOutDTO> putStudent(@PathVariable long id,
	                                                @RequestBody StudentInDTO studentRequest) {

		return ResponseEntity
				.ok()
				.body(studentMapper.toDTO(studentService.updateStudent(studentRequest, id)));
	}

	@PatchMapping("/{id}")
	public ResponseEntity<StudentOutDTO> patchStudent(@PathVariable long id,
	                                                  @RequestBody PatchStudentDTO patchStudentRequest) {

		return ResponseEntity
				.ok()
				.body(studentMapper.toDTO(studentService.patchMapping(patchStudentRequest, id)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<BasicDTO> deleteStudent(@PathVariable long id) {
		studentService.deleteStudent(id);

		return ResponseEntity
				.ok()
				.body(new BasicDTO("Sa borrao"));
	}
}
