package wilp.dda.vaccinationtool.repository.entity;

import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Builder
@Table(name = "appointment")
public class AppointmentEntity {
}
