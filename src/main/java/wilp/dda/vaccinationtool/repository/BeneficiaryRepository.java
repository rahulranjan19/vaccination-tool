package wilp.dda.vaccinationtool.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wilp.dda.vaccinationtool.repository.entity.BeneficiaryEntity;

import java.util.List;

@Repository
public interface BeneficiaryRepository extends CrudRepository<BeneficiaryEntity, String> {
//    List<BeneficiaryEntity> findAllByUserid(String userId);
}
