package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import server.models.Activity;

import java.util.UUID;

public interface ActivityRepository extends JpaRepository<Activity, UUID> {

}
