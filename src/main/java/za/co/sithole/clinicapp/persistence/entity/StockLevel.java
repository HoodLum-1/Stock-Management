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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stock_level")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockLevel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "stock_level_id")
  private Long id;

  @OneToOne
  @JoinColumn(name = "clinic_id", referencedColumnName = "clinic_id")
  private Clinic clinic;

  @OneToOne
  @JoinColumn(name = "medication_id", referencedColumnName = "medication_id")
  private Medication medication;

  private int quantity;
}
