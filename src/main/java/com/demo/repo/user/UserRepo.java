package com.demo.repo.user;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.user.UserEntity;

@Repository
public interface UserRepo extends MongoRepository<UserEntity, Long> {

	Optional<UserEntity> findByUserName(String userName);

}
