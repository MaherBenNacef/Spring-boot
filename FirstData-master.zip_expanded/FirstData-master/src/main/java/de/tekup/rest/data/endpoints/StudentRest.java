package de.tekup.rest.data.endpoints;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.rest.data.models.ClassRoomEntity;
import de.tekup.rest.data.models.PersonEntity;
import de.tekup.rest.data.models.StudentEntity;
import de.tekup.rest.data.services.StudientService;

@RestController
@RequestMapping("/api/student")
public class StudentRest {

	private StudientService service;

	public StudentRest(StudientService service) {
		super();
		this.service=service;
	}
	@GetMapping
	public List<StudentEntity> getAll() {
		return service.getAllStudientEntities();
	}

	@PostMapping
	public StudentEntity createStudent(@RequestBody StudentEntity student) {
		return service.createStudientEntity(student);
	}

	@GetMapping("/{id}")
	public StudentEntity getStudentById(@PathVariable("id") long id) {
		return service.getStudientEntityById(id);
	}
	
	@DeleteMapping("/{id}")
	public StudentEntity deleteStudentById(@PathVariable("id") long id) {
		return service.deleteStudientEntityById(id);
	}
	
	@PutMapping("/{id}")
	public StudentEntity updateStudent(@PathVariable("id") long id, @RequestBody StudentEntity newStudent) {
		return service.modifyStudientEntity(id, newStudent);
	}
	

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);

	}

	
	
}
