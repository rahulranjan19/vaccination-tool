package wilp.dda.vaccinationtool.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wilp.dda.vaccinationtool.repository.entity.RegisterEntity;
import wilp.dda.vaccinationtool.repository.entity.id.RegisterEntityId;

@Repository
public interface RegisterRepository extends CrudRepository<RegisterEntity, RegisterEntityId> {
}
