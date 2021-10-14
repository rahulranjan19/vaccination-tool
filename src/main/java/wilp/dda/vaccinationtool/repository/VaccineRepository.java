package wilp.dda.vaccinationtool.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wilp.dda.vaccinationtool.repository.entity.VaccineEntity;

@Repository
public interface VaccineRepository extends CrudRepository<VaccineEntity, String> {
}
