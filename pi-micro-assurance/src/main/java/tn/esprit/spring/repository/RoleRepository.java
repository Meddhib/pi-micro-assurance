package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.dao.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

}
