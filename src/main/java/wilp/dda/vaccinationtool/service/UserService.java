package wilp.dda.vaccinationtool.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wilp.dda.vaccinationtool.repository.UserRepository;
import wilp.dda.vaccinationtool.repository.entity.UserEntity;
import wilp.dda.vaccinationtool.web.user.model.AddUserRequest;
import wilp.dda.vaccinationtool.web.user.model.SaveUserRequest;
import wilp.dda.vaccinationtool.web.user.model.UserResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void updateUser(String userId, AddUserRequest request) {
        repository.findById(userId).ifPresent(user -> repository.save(UserEntity.builder().build()));
    }

    public void saveUser(SaveUserRequest request) {
        repository.save(UserEntity.builder().build());
    }

    public UserResponse getUser(String userId) {
        Optional<UserEntity> userEntityOpt = repository.findById(userId);
        return UserResponse.builder().build();
    }

    public List<UserResponse> getUsers() {
        Iterable<UserEntity> users = repository.findAll();
        return new ArrayList<>();
    }
}
