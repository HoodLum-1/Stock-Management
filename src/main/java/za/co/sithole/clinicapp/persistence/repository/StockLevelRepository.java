package za.co.sithole.clinicapp.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.sithole.clinicapp.persistence.entity.StockLevel;

@Repository
public interface StockLevelRepository extends JpaRepository<StockLevel, Long> {
}
