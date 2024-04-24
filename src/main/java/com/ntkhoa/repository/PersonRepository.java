package com.ntkhoa.repository;

import com.ntkhoa.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person,Long> {
    List<Person> findByLastName(String lastName);
}
