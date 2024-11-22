package net.escoz.studentsbff.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentOutDTO {

	private long id;
	private String name;
	private String username;
	private String email;
	private int age;

}
