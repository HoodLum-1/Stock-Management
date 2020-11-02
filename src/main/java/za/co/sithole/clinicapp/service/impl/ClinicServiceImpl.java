package za.co.sithole.clinicapp.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sithole.clinicapp.persistence.entity.Clinic;
import za.co.sithole.clinicapp.persistence.entity.Medication;
import za.co.sithole.clinicapp.persistence.entity.StockLevel;
import za.co.sithole.clinicapp.persistence.repository.ClinicRepository;
import za.co.sithole.clinicapp.persistence.repository.MedicationRepository;
import za.co.sithole.clinicapp.persistence.repository.StockLevelRepository;
import za.co.sithole.clinicapp.service.ClinicService;
import za.co.sithole.clinicapp.service.exceptions.ClinicException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ClinicServiceImpl implements ClinicService {

  private boolean initialised = false;

  private MedicationRepository medicationRepository;
  private ClinicRepository clinicRepository;
  private StockLevelRepository stockLevelRepository;

  @Autowired
  public ClinicServiceImpl(final MedicationRepository medicationRepository, final ClinicRepository clinicRepository, final StockLevelRepository stockLevelRepository) {
    this.medicationRepository = medicationRepository;
    this.clinicRepository = clinicRepository;
    this.stockLevelRepository = stockLevelRepository;
  }

  @Override
  public void createClinic(Clinic newClinic) {
    try {
      clinicRepository.save(newClinic);
    } catch (final Exception e) {
      throw new ClinicException("Cannot create new clinic", e.getCause().getMessage());
    }

  }

  @Override
  public void addMedicineToClinic(Long clinicId, Medication medication, int quantity) {
    final Medication newMedication = findOrReturnNewMedication(medication);
    clinicRepository.findById(clinicId).ifPresentOrElse(clinic -> {
      final StockLevel stockLevel = new StockLevel();

      stockLevel.setClinic(clinic);
      stockLevel.setMedication(newMedication);
      stockLevel.setQuantity(quantity);
      stockLevelRepository.save(stockLevel);
    }, () -> {
      throw new ClinicException("addMedicineToClinic", "Error occured trying to save clinic");
    });

  }

  @Override
  public Clinic getClinicById(Long clinicId) {
    log.info("Getting clinic by id {}", clinicId);
    return clinicRepository.findById(clinicId).get();
  }

  @Override
  public List<Clinic> getAllClinics() {
    if(!initialised) {
      createSampleClinics(10);
    }

    log.info("Finding all clinics");

    return clinicRepository.findAll();

  }

  private Medication findOrReturnNewMedication(Medication medication) {
    return medicationRepository.findByMedicationName(medication.getMedicationName()).orElse(medication);
  }

  //TODO Malesla - Load Proper clinics with names
  private void createSampleClinics(int numberOfClinics) {
    clinicRepository.deleteAll();
    log.info("creating sample clinics {}", numberOfClinics);
    List<Clinic> clinics = new ArrayList<>();
    for(int i = 0; i < numberOfClinics; i++) {
      final Clinic clinic = new Clinic();
      clinic.setClinicLocation("location " + i);
      clinic.setClinicName("Clinic " + i);
      clinic.setDateCreated(new Date());
      clinics.add(clinic);
    }


    clinicRepository.saveAll(clinics);
    initialised = true;
  }
}
