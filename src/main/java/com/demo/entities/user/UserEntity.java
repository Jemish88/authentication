package com.demo.entities.user;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

	@Id
	private String id;

	@Nonnull
	private String userName;

	@Nonnull
	private String email;

	@Nonnull
	private String password;

	@DBRef
	private Set<RoleEntity> role = new HashSet<>();

}
