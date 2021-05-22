package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import server.models.Person;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {
}