package actions.service;

import java.util.List;

import org.springframework.stereotype.Service;

import actions.entity.Student;
import actions.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StudentService {

	private final StudentRepository studentRepository;
	
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	public Student getStudent(Long id) {
		return studentRepository.findById(id).orElseThrow();
	}

	@Transactional
	public Student createStudent(Student newStudent) {
		return studentRepository.save(newStudent);
	}

	@Transactional
	public Student updateStudent(Student updated, Long id) {
		Student student = studentRepository.findById(id).orElseThrow();
		
		student.setName(updated.getName());
		
		return student;
	}
	
	@Transactional
	public Student deleteStudent(Long id) {
		Student student = studentRepository.findById(id).orElseThrow();
		
		studentRepository.delete(student);
		
		return student;
	}
}
