package za.co.sithole.clinicapp.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.sithole.clinicapp.persistence.entity.Clinic;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic, Long> {
}
