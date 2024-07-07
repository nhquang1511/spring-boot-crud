package com.example.cardatabase.domain;

import org.springframework.data.repository.CrudRepository;


import com.example.cardatabase.entity.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
	
}
