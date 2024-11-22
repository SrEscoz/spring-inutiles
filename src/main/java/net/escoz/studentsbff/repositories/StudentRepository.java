package net.escoz.studentsbff.repositories;

import net.escoz.studentsbff.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	Optional<Student> findStudentByName(String name);

	Optional<Student> findStudentByEmail(String email);

}
