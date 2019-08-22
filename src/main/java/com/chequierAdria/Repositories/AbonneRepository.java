package com.chequierAdria.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chequierAdria.Entities.Abonne;

@Repository
public interface AbonneRepository extends CrudRepository<Abonne,Long>
{
	Abonne findByUsername(String username);
}
