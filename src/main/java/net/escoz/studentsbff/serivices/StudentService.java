package net.escoz.studentsbff.serivices;

import net.escoz.studentsbff.controllers.dtos.PatchStudentDTO;
import net.escoz.studentsbff.controllers.dtos.StudentInDTO;
import net.escoz.studentsbff.models.Student;

import java.util.List;

public interface StudentService {

	List<Student> getAllStudents();

	Student getStudent(long id);

	Student addStudent(Student student);

	Student updateStudent(StudentInDTO student, long id);

	Student patchMapping(PatchStudentDTO studentDTO, long id);

	void deleteStudent(long id);
}
