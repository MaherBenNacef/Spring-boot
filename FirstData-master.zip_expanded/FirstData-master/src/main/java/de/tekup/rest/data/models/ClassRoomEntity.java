package de.tekup.rest.data.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class ClassRoomEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private int number;
	private String city;
	@OneToOne(mappedBy = "classRoom")
	@JsonIgnore
	private StudentEntity student;

}
