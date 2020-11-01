package de.tekup.rest.data.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import java.util.List;
// table name must be Strdent
// Turn this to Entity and  create the CRUD of this Entity
@Data
@Entity
@Table(name = "student")
public class StudentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length = 60,nullable = false)
	private String name; // name not null, with 60 chars
	@Column(unique = true,length = 4)
	private int code; // unique code over 4 numbers
	@OneToOne
	private ClassRoomEntity classRoom;
	@OneToMany(mappedBy = "student")
	public List<TelephoneNumberEntity> telephoneNumber;
	@ManyToMany(mappedBy = "student")
	public List<GamesEntity> game;

}
