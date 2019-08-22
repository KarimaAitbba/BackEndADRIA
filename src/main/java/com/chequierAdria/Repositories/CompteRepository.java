package com.chequierAdria.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.chequierAdria.Entities.Abonne;
import com.chequierAdria.Entities.Compte;

public interface CompteRepository extends CrudRepository<Compte,Long>
{
    Compte findByNumCompte(int numCompte);
    Iterable<Compte> findByAbonne(Abonne abonne);
}
