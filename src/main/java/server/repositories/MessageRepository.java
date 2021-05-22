package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import server.models.Message;

import java.util.UUID;

public interface MessageRepository extends JpaRepository<Message, UUID> {
}
