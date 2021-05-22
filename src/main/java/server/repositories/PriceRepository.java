package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import server.models.Price;

import java.util.UUID;

public interface PriceRepository extends JpaRepository<Price, UUID> {
}
