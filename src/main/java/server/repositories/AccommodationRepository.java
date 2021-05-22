package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import server.models.Accommodation;
import java.util.UUID;

public interface AccommodationRepository extends JpaRepository<Accommodation, UUID>{

}
