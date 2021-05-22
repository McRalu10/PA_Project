package server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.models.Person;
import server.services.PersonService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("persons")
public class PersonController {
    @Autowired
    private PersonService service;

    @GetMapping()
    public ResponseEntity<List<Person>> getPersons(){
        List<Person> Persons = service.getAllPersons();
        return new ResponseEntity<>(Persons, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonByID(@PathVariable UUID id){
        Person existingPerson = service.getPersonByID(id);
        if(existingPerson==null){
            return new ResponseEntity<>(new HttpHeaders(),HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(existingPerson, new HttpHeaders(),HttpStatus.OK);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Person> create(@RequestBody Person Person)
    {
        Person newPerson=service.create(Person);
        return new ResponseEntity<>(newPerson, new HttpHeaders(),HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Person> update(@RequestBody Person Person){
        Person newPerson=service.update(Person);
        if(newPerson != null){
            return new ResponseEntity<>(newPerson, new HttpHeaders(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>( new HttpHeaders(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        if(service.deletePerson(id)){
            return new ResponseEntity<>(new HttpHeaders(),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(new HttpHeaders(),HttpStatus.NOT_FOUND);
        }
    }
}
