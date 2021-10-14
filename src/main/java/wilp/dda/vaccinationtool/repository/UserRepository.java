package wilp.dda.vaccinationtool.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wilp.dda.vaccinationtool.repository.entity.UserEntity;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {
    List<UserEntity> findAllByParentId(String userId);
}
