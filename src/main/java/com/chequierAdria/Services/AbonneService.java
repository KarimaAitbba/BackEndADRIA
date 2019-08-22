package com.chequierAdria.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chequierAdria.Entities.Abonne;
import com.chequierAdria.Repositories.AbonneRepository;

@Service
public class AbonneService
{
	@Autowired
	AbonneRepository abonneRepository;
	
	public Abonne save(Abonne abonne)
	{
		return abonneRepository.save(abonne);
	}
	public Iterable<Abonne> findAllSubscribers()
	{
        return abonneRepository.findAll();
    }

}
