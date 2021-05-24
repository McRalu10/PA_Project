package server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.models.User;
import server.services.UserService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = service.getAllUsers();
        return new ResponseEntity<>(users, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserByID(@PathVariable UUID id) {
        Optional<User> existingUser = service.getUserByID(id);
        if (existingUser.isEmpty()) {
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(existingUser, new HttpHeaders(), HttpStatus.OK);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<User> create(@RequestBody User User) {
        User newUser = service.create(User);
        return new ResponseEntity<>(newUser, new HttpHeaders(), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Optional<User> newUser = service.login(user);
        if (newUser.isEmpty())
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(newUser, new HttpHeaders(), HttpStatus.CREATED);
    }

    @PutMapping("/reset")
    public ResponseEntity<?> resetPassword(@RequestBody User user) {
        Optional<User> newUser = service.resetPassword(user);
        if (newUser.isEmpty())
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(newUser, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody User User) {
        User newUser = service.update(User);
        if (newUser != null) {
            return new ResponseEntity<>(newUser, new HttpHeaders(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        if (service.deletePerson(id)) {
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/out/{userID}")
    public ResponseEntity<?> signOut(@PathVariable UUID userID) {
        return new ResponseEntity<>(service.signOut(userID), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/checkin/{userID}")
    public ResponseEntity<?> checkIn(@PathVariable UUID userID) {
        return new ResponseEntity<>(service.checkIn(userID), new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("/checkout/{userID}")
    public ResponseEntity<?> checkOut(@PathVariable UUID userID) {
        return new ResponseEntity<>(service.checkOut(userID), new HttpHeaders(), HttpStatus.OK);
    }
}
