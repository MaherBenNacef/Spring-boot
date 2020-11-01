package de.tekup.rest.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.rest.data.models.PersonEntity;
import de.tekup.rest.data.models.StudentEntity;

public interface StudientRepository extends JpaRepository<StudentEntity, Long>{

}
