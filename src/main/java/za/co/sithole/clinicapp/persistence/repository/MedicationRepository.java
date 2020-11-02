package za.co.sithole.clinicapp.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.sithole.clinicapp.persistence.entity.Medication;

import java.util.Optional;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {
  Optional<Medication> findByMedicationName(String medicationName);
}
