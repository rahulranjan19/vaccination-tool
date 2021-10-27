package wilp.dda.vaccinationtool.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wilp.dda.vaccinationtool.repository.entity.CenterEntity;

@Repository
public interface CenterRepository extends CrudRepository<CenterEntity, String> {
//    List<CenterEntity> findAllByUserId(String userId);
}
