package com.chequierAdria.Entities;
import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Demande implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message="reason is required")
	private String motif;
	@Column(updatable = false)
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-mm-dd")
	private LocalDate dateCreation;
	private LocalDate dateEnvoie;
	private String status;
	
	private int nombreCheque;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="ID_CPT")
	private Compte compte;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Demande(Long id,String motif, String status, int nombreCheque, Compte compte) {
		super();
		this.id=id;
		this.motif = motif;
		this.status = status;
		this.nombreCheque= nombreCheque;
		this.compte = compte;
	}

	public int getNombreCheque() {
		return nombreCheque;
	}

	public void setNombreCheque(int nombreCheque) {
		this.nombreCheque = nombreCheque;
	}

	public Demande() {
		super();
	}
	
	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}
	public LocalDate getDateEnvoie() {
		return dateEnvoie;
	}

	public void setDateEnvoie(LocalDate dateEnvoie) {
		this.dateEnvoie = dateEnvoie;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@PrePersist
	protected void OnCreate()
	{
		this.dateCreation= LocalDate.now();
	}

	@Override
	public String toString() {
		return "Demande [id=" + id + ", motif=" + motif + ", date_creation="/* + dateCreation */+ ", date_envoie="
				+ dateEnvoie + ", status=" + status + ", compte=" + compte + "]";
	}

	

}
