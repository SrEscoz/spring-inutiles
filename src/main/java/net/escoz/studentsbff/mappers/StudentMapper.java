package net.escoz.studentsbff.mappers;

import net.escoz.studentsbff.controllers.dtos.StudentOutDTO;
import net.escoz.studentsbff.models.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

	StudentOutDTO toDTO(Student student);
}
