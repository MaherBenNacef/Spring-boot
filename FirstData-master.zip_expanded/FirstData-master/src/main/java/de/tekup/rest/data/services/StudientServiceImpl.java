package de.tekup.rest.data.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.rest.data.models.ClassRoomEntity;
import de.tekup.rest.data.models.GamesEntity;
import de.tekup.rest.data.models.PersonEntity;
import de.tekup.rest.data.models.StudentEntity;
import de.tekup.rest.data.models.TelephoneNumberEntity;
import de.tekup.rest.data.repositories.ClassRoomRepository;
import de.tekup.rest.data.repositories.GamesRepository;
import de.tekup.rest.data.repositories.StudientRepository;
import de.tekup.rest.data.repositories.TelephoneNumberRepository;

@Service
public class StudientServiceImpl implements StudientService{
	
	private StudientRepository respo;
	private ClassRoomRepository repo;
	private TelephoneNumberRepository rep;
	private GamesRepository repository;
	
	
	@Autowired
	public StudientServiceImpl(StudientRepository respo, ClassRoomRepository repo, TelephoneNumberRepository rep,
			GamesRepository repository) {
		super();
		this.respo = respo;
		this.repo = repo;
		this.rep = rep;
		this.repository = repository;
	}

	@Override
	public StudentEntity createStudientEntity(StudentEntity entity) {
		ClassRoomEntity room =entity.getClassRoom();
		ClassRoomEntity RoomInBase= repo.save(room);
		entity.setClassRoom(RoomInBase);
		entity = respo.save(entity);
		//save person in telephoneNumber so this is why we add tel.setStudent in the for 
		for (TelephoneNumberEntity tel : entity.getTelephoneNumber()) {
			tel.setStudent(entity);
			rep.save(tel);
			
		}
		List<StudentEntity> student;
		for(GamesEntity games : entity.getGame())
		{
				if(games.getStudent()!=null) {
					student=games.getStudent();
				}else {
					student=new ArrayList<>();
				}
				student.add(entity);
				games.setStudent(student);
				repository.save(games);
			
			
			
		}
		return entity;
	}


	@Override
	public StudentEntity deleteStudientEntityById(long id) {
		StudentEntity entity = this.getStudientEntityById(id);
		respo.deleteById(id);
		return entity;
	}
	@Override
	public List<StudentEntity> getAllStudientEntities() {
		// TODO Auto-generated method stub
		return respo.findAll();
	}
	@Override
	public StudentEntity getStudientEntityById(long id) {
		StudentEntity entity;
		Optional<StudentEntity> opt = respo.findById(id);
		if(opt.isPresent())
			entity = opt.get();
		else
			throw new NoSuchElementException("Studient with this id is not found");
		
		return entity;
	}
	@Override
	public StudentEntity modifyStudientEntity(long id, StudentEntity entity) {
		StudentEntity oldEntity = this.getStudientEntityById(id);
		if(entity.getName() != null)
			oldEntity.setName(entity.getName());
		if(entity.getCode() != 0)
			oldEntity.setCode(entity.getCode());
		
		
		return respo.save(oldEntity);
	}

}
