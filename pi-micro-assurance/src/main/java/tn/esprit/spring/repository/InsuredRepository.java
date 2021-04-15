package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.dao.entities.Insured;

@Repository
public interface InsuredRepository extends JpaRepository<Insured,Long>{
	
	
	
}
