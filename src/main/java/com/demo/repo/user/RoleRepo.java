package com.demo.repo.user;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.user.RoleEntity;

@Repository
public interface RoleRepo extends MongoRepository<RoleEntity, String>{

	Optional<RoleEntity> findByName(Set<RoleEntity> role);
	

}
