package server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.models.User;
import server.services.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("persons")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping()
    public ResponseEntity<List<User>> getPersons(){
        List<User> users = service.getAllPersons();
        return new ResponseEntity<>(users, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getPersonByID(@PathVariable UUID id){
        User existingUser = service.getPersonByID(id);
        if(existingUser ==null){
            return new ResponseEntity<>(new HttpHeaders(),HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(existingUser, new HttpHeaders(),HttpStatus.OK);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User User)
    {
        User newUser =service.create(User);
        return new ResponseEntity<>(newUser, new HttpHeaders(),HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody User User){
        User newUser =service.update(User);
        if(newUser != null){
            return new ResponseEntity<>(newUser, new HttpHeaders(), HttpStatus.OK);
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
