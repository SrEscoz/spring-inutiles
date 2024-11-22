package net.escoz.studentsbff.mappers;

import net.escoz.studentsbff.controllers.dtos.PatchStudentDTO;
import net.escoz.studentsbff.controllers.dtos.StudentInDTO;
import net.escoz.studentsbff.controllers.dtos.StudentOutDTO;
import net.escoz.studentsbff.models.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

	StudentOutDTO toDTO(Student student);

	List<StudentOutDTO> toDTOs(List<Student> students);

	@Mapping(target = "id", ignore = true)
	Student toModel(StudentInDTO studentInDTO);

	@Mapping(target = "id", ignore = true)
	Student update(@MappingTarget Student student, StudentInDTO studentInDTO);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "name", ignore = true)
	@Mapping(target = "age", ignore = true)
	Student patch(@MappingTarget Student student, PatchStudentDTO patchStudentDTO);
}
