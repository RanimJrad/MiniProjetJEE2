package com.ranim.supermarches.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomSuper", types = { Supermarche.class })
public interface SupermarcheProjection {
	
	public String getNomSupermarche();

}
