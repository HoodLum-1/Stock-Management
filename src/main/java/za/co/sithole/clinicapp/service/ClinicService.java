package za.co.sithole.clinicapp.service;

import za.co.sithole.clinicapp.persistence.entity.Clinic;
import za.co.sithole.clinicapp.persistence.entity.Medication;

import java.util.List;

public interface ClinicService {
  void createClinic(Clinic clinic);
  void addMedicineToClinic(Long clinicId, Medication medication, int quantity);

  List<Clinic> getAllClinics();

  Clinic getClinicById(Long id);
}
