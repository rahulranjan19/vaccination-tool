package wilp.dda.vaccinationtool.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wilp.dda.vaccinationtool.repository.BeneficiaryRepository;
import wilp.dda.vaccinationtool.repository.RegisterRepository;
import wilp.dda.vaccinationtool.repository.entity.BeneficiaryEntity;
import wilp.dda.vaccinationtool.web.register.model.RegisterResponse;
import wilp.dda.vaccinationtool.web.beneficiary.model.AddBeneficiaryRequest;
import wilp.dda.vaccinationtool.web.beneficiary.model.SaveBeneficiaryRequest;
import wilp.dda.vaccinationtool.web.beneficiary.model.BeneficiaryResponse;

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

    public void updateUser(String userId, AddBeneficiaryRequest request) {
        userRepository.findById(userId).ifPresent(user -> userRepository.save(BeneficiaryEntity.builder().build()));
    }

    public void saveUser(SaveBeneficiaryRequest request) {
        userRepository.save(BeneficiaryEntity.builder().build());
    }

    public BeneficiaryResponse getUser(String userId) {
        Optional<BeneficiaryEntity> userEntityOpt = userRepository.findById(userId);
        return BeneficiaryResponse.builder().build();
    }

    public List<BeneficiaryResponse> getUsers() {
        Iterable<BeneficiaryEntity> users = userRepository.findAll();
        return new ArrayList<>();
    }

    public List<RegisterResponse> getUserAppointments(String userId) {
//        appointmentRepository.findAllByUserId(userId);
        return new ArrayList<>();
    }

    public List<BeneficiaryResponse> getUserBeneficiaries(String userId) {
//        userRepository.findAllByUserid(userId);
        return new ArrayList<>();
    }

    public List<BeneficiaryResponse> getBeneficiaries(String userId) {
        return null;
    }
}
