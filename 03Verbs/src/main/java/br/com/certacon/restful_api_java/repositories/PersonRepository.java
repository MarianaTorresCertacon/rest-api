package br.com.certacon.restful_api_java.repositories;

import br.com.certacon.restful_api_java.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}
