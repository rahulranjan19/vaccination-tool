package wilp.dda.vaccinationtool.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wilp.dda.vaccinationtool.repository.BeneficiaryRepository;
import wilp.dda.vaccinationtool.repository.RegisterRepository;
import wilp.dda.vaccinationtool.repository.entity.BeneficiaryEntity;
import wilp.dda.vaccinationtool.web.appointment.model.AppointmentResponse;
import wilp.dda.vaccinationtool.web.user.model.AddUserRequest;
import wilp.dda.vaccinationtool.web.user.model.SaveUserRequest;
import wilp.dda.vaccinationtool.web.user.model.UserResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class BeneficiaryService {

    @Autowired
    private BeneficiaryRepository userRepository;

    @Autowired
    private RegisterRepository appointmentRepository;

    public void updateUser(String userId, AddUserRequest request) {
        userRepository.findById(userId).ifPresent(user -> userRepository.save(BeneficiaryEntity.builder().build()));
    }

    public void saveUser(SaveUserRequest request) {
        userRepository.save(BeneficiaryEntity.builder().build());
    }

    public UserResponse getUser(String userId) {
        Optional<BeneficiaryEntity> userEntityOpt = userRepository.findById(userId);
        return UserResponse.builder().build();
    }

    public List<UserResponse> getUsers() {
        Iterable<BeneficiaryEntity> users = userRepository.findAll();
        return new ArrayList<>();
    }

    public List<AppointmentResponse> getUserAppointments(String userId) {
//        appointmentRepository.findAllByUserId(userId);
        return new ArrayList<>();
    }

    public List<UserResponse> getUserBeneficiaries(String userId) {
//        userRepository.findAllByUserid(userId);
        return new ArrayList<>();
    }
}