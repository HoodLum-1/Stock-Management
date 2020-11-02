package za.co.sithole.clinicapp.persistence.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "clinic")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Clinic {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "clinic_id")
  private Long id;

  private String clinicName;
  private String clinicLocation;

  @CreationTimestamp
  @Temporal(TemporalType.DATE)
  private Date dateCreated;
}
