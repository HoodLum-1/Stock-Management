package za.co.sithole.clinicapp.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medication")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Medication {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "medication_id")
  private Long medicationId;

  @Column(unique = true)
  private String medicationName;
  private String medicationDescription;
}
