package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import server.models.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}