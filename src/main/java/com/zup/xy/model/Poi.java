package com.zup.xy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Poi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomePoi;
	private Integer coordenadaX;
	private Integer coordenadaY;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomePoi() {
		return nomePoi;
	}
	public void setNomePoi(String nomePoi) {
		this.nomePoi = nomePoi;
	}
	public Integer getCoordenadaX() {
		return coordenadaX;
	}
	public void setCoordenadaX(Integer coordenadaX) {
		this.coordenadaX = coordenadaX;
	}
	public Integer getCoordenadaY() {
		return coordenadaY;
	}
	public void setCoordenadaY(Integer coordenadaY) {
		this.coordenadaY = coordenadaY;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordenadaX == null) ? 0 : coordenadaX.hashCode());
		result = prime * result + ((coordenadaY == null) ? 0 : coordenadaY.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomePoi == null) ? 0 : nomePoi.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Poi other = (Poi) obj;
		if (coordenadaX == null) {
			if (other.coordenadaX != null)
				return false;
		} else if (!coordenadaX.equals(other.coordenadaX))
			return false;
		if (coordenadaY == null) {
			if (other.coordenadaY != null)
				return false;
		} else if (!coordenadaY.equals(other.coordenadaY))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomePoi == null) {
			if (other.nomePoi != null)
				return false;
		} else if (!nomePoi.equals(other.nomePoi))
			return false;
		return true;
	}
	
	
	
}
