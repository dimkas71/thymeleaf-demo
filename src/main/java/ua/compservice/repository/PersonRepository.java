package ua.compservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.compservice.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
