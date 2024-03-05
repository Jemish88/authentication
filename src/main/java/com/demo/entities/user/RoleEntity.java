package com.demo.entities.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.demo.constants.user.ERole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleEntity {

	@Id
	private String id;

	private ERole name;

}
