package com.ntkhoa.controller;

import com.ntkhoa.entity.Person;
import com.ntkhoa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public @ResponseBody Person getAllUsers(@PathVariable Long id){
        return personService.getPersonById(id).get();
    }

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public List<Person> getPersoneByName(@PathVariable String lastName) {
        return personService.findByLastName(lastName);
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public HttpStatus insertPersone(@RequestBody Person person) {
        personService.addPerson(person);
        return HttpStatus.CREATED;
    }

    @RequestMapping(value = "/person", method = RequestMethod.PUT)
    public HttpStatus updatePersone(@RequestBody Person person) {
        personService.updatePerson(person);
        return HttpStatus.OK;
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
    public HttpStatus deletePersone(@PathVariable Long id) {
        personService.deletePerson(id);
        return HttpStatus.OK;
    }
}
