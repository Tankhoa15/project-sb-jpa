package com.ntkhoa.service;

import com.ntkhoa.entity.Person;
import com.ntkhoa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepo;

    //get all person
    public List<Person> getAllPerson(){
        return (List<Person>) personRepo.findAll();
    }

    // find by last name
    public List<Person> findByLastName(String lastName){
        return personRepo.findByLastName(lastName);
    }

    // get id
    public Optional<Person> getPersonById(Long id){
        return personRepo.findById(id);
    }

    // add person
    public void addPerson(Person person){
        personRepo.save(person);
    }

    // update person
    public void updatePerson(Person person){
        personRepo.save(person);
    }

    // delete person
    public void deletePerson(Long id){
        personRepo.deleteById(id);
    }
}
