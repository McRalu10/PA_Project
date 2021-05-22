package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import server.models.Notification;
import java.util.UUID;

public interface NotificationRepository extends JpaRepository<Notification, UUID> {
}
