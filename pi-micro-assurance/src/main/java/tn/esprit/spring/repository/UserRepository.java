package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.dao.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
