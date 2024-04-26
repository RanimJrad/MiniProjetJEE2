package com.ranim.supermarches.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ranim.supermarches.entities.Supermarche;
import com.ranim.supermarches.entities.Type;

@RepositoryRestResource(path = "rest")
public interface SupermarcheRepository extends JpaRepository<Supermarche, Long> {

	List<Supermarche> findByNomSupermarche(String nom);
	List<Supermarche> findByNomSupermarcheContains(String nom);
	
	@Query("select s from Supermarche s where s.nomSupermarche like %:nom and s.prixSupermarche > :prix")
	List<Supermarche> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	
	@Query("select s from Supermarche s where s.type = ?1")
	List<Supermarche> findByType (Type type);
	
	List<Supermarche> findByTypeIdType(Long id);
	
	List<Supermarche> findByOrderByNomSupermarcheAsc();
	
	@Query("select s from Supermarche s order by s.nomSupermarche ASC, s.prixSupermarche DESC")
	List<Supermarche> trierSupermarchesNomsPrix ();
}
