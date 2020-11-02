package za.co.sithole.clinicapp.service.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClinicException extends RuntimeException {
  private String error;
  private String exceptionCause;
}
