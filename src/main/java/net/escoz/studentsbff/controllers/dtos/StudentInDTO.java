package net.escoz.studentsbff.controllers.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentInDTO {

	private String name;
	private String username;
	private String email;
	private int age;
}
