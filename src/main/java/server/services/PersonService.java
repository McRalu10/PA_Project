package server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.models.Person;
import server.repositories.PersonRepository;

import java.util.*;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public List<Person> getAllPersons() {
        List<Person> allPersons = repository.findAll();
        if (!allPersons.isEmpty()) {
            return allPersons;
        } else {
            return new ArrayList<>();
        }
    }
    public Person getPersonByID(UUID id) {
        List<Person> allPersons = repository.findAll();
        for (Person existingPerson : allPersons) {
            if (existingPerson.getPersonID().equals(id)) {
                return existingPerson;
            }
        }
        return null;
    }

    public Person create(Person Person) {
        Person.setPersonID(UUID.randomUUID());
        Person.setCreationDate(new Date());
        Person = repository.save(Person);
        return Person;
    }

    public Person update(Person person) {
        UUID id = person.getPersonID();
        Optional<Person> availablePerson=repository.findById(id);
        Person newPerson;
        if (availablePerson.isPresent()) {
            newPerson = availablePerson.get();
            if (person.getName() != null) {
                newPerson.setName(person.getName());
            }
            repository.save(newPerson);
            return newPerson;
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
