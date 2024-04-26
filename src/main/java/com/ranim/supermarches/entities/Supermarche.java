package com.ranim.supermarches.entities;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Supermarche {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSupermarche;
	private String nomSupermarche;
	private Double prixSupermarche;
	private Date dateConstruction;
	
	@ManyToOne
	private Type type;

	public Supermarche() {
		super();
	}

	public Supermarche(String nomSupermarche, Double prixSupermarche, Date dateConstruction) {
		super();
		this.nomSupermarche = nomSupermarche;
		this.prixSupermarche = prixSupermarche;
		this.dateConstruction = dateConstruction;
	}

	public Long getIdSupermarche() {
		return idSupermarche;
	}

	public void setIdSupermarche(Long idSupermarche) {
		this.idSupermarche = idSupermarche;
	}

	public String getNomSupermarche() {
		return nomSupermarche;
	}

	public void setNomSupermarche(String nomSupermarche) {
		this.nomSupermarche = nomSupermarche;
	}

	public Double getPrixSupermarche() {
		return prixSupermarche;
	}

	public void setPrixSupermarche(Double prixSupermarche) {
		this.prixSupermarche = prixSupermarche;
	}

	public Date getDateConstruction() {
		return dateConstruction;
	}

	public void setDateConstruction(Date dateConstruction) {
		this.dateConstruction = dateConstruction;
	}

	@Override
	public String toString() {
		return "Supermarche [idSupermarche=" + idSupermarche + ", nomSupermarche=" + nomSupermarche
				+ ", prixSupermarche=" + prixSupermarche + ", dateConstruction=" + dateConstruction + "]";
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
