package server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.models.User;
import server.repositories.UserRepository;

import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() {
        List<User> allUsers = repository.findAll();
        if (!allUsers.isEmpty()) {
            return allUsers;
        } else {
            return new ArrayList<>();
        }
    }

    public Optional<User> getUserByID(UUID id) {
        return repository.findById(id);
    }

    public User create(User user) {
        user.setUserID(UUID.randomUUID());
        user.setCreationDate(new Date());
        user.setLogged(true);
        return repository.save(user);

    }

    public Optional<User> login(User user) {
        Optional<User> existingUser = repository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            if (user.getPassword().equals(existingUser.get().getPassword())) {
                user.setLogged(true);
                repository.save(user);

            }
        }
        return existingUser;
    }
    public Optional<User> resetPassword(User user){
        Optional<User> existingUser = repository.findByEmail(user.getEmail());
        if(existingUser.isPresent()){
            User updatedUser = existingUser.get();
            updatedUser.setPassword(user.getPassword());
            repository.save(updatedUser);
        }
        return existingUser;
    }

    public User update(User user) {
        UUID id = user.getUserID();
        Optional<User> availablePerson = repository.findById(id);
        User newUser;
        if (availablePerson.isPresent()) {
            newUser = availablePerson.get();
            if (user.getName() != null) {
                newUser.setName(user.getName());
            }
            repository.save(newUser);
            return newUser;
        } else {
            return null;
        }
    }

    public boolean deletePerson(UUID id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return repository.existsById(id);
    }

}
