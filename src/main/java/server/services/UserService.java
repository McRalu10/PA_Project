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

    public List<User> getAllPersons() {
        List<User> allUsers = repository.findAll();
        if (!allUsers.isEmpty()) {
            return allUsers;
        } else {
            return new ArrayList<>();
        }
    }
    public User getPersonByID(UUID id) {
        List<User> allUsers = repository.findAll();
        for (User existingUser : allUsers) {
            if (existingUser.getPersonID().equals(id)) {
                return existingUser;
            }
        }
        return null;
    }

    public User create(User User) {
        User.setPersonID(UUID.randomUUID());
        User.setCreationDate(new Date());
        User = repository.save(User);
        return User;
    }

    public User update(User user) {
        UUID id = user.getPersonID();
        Optional<User> availablePerson=repository.findById(id);
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
        }
        return repository.existsById(id);
    }

}
