package wilp.dda.vaccinationtool.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wilp.dda.vaccinationtool.repository.entity.AppointmentEntity;
import wilp.dda.vaccinationtool.repository.entity.UserEntity;

@Repository
public interface AppointmentRepository extends CrudRepository<AppointmentEntity, String> {
}
