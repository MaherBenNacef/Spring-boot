package de.tekup.rest.data.services;

import java.util.List;


import de.tekup.rest.data.models.StudentEntity;

public interface StudientService {
	StudentEntity createStudientEntity(StudentEntity entity);
	List<StudentEntity> getAllStudientEntities();
	StudentEntity getStudientEntityById(long id);
	StudentEntity modifyStudientEntity(long id, StudentEntity entity);
	StudentEntity deleteStudientEntityById(long id);
}
