package com.chequierAdria.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chequierAdria.Entities.Abonne;
import com.chequierAdria.Services.AbonneService;

@RestController
@RequestMapping("api/abonne")
@CrossOrigin
public class AbonneController
{
	@Autowired
	AbonneService abonneService;
	@PostMapping("")
	ResponseEntity<Abonne> addSubscriber(@Valid @RequestBody Abonne ab)
	{
		Abonne abonne=abonneService.save(ab);
		return new ResponseEntity<Abonne>(abonne, HttpStatus.CREATED);
	}
	@GetMapping("/all")
    public Iterable<Abonne> getAllSubscribers()
	{
		return abonneService.findAllSubscribers();
	}
}
