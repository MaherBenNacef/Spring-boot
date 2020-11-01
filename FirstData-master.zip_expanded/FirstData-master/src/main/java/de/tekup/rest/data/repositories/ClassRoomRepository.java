package de.tekup.rest.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.rest.data.models.ClassRoomEntity;

public interface ClassRoomRepository extends JpaRepository<ClassRoomEntity, Integer>{

}
