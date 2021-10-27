package wilp.dda.vaccinationtool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wilp.dda.vaccinationtool.repository.BeneficiaryRepository;
import wilp.dda.vaccinationtool.repository.CenterRepository;
import wilp.dda.vaccinationtool.repository.RegisterRepository;
import wilp.dda.vaccinationtool.repository.VaccineRepository;
import wilp.dda.vaccinationtool.repository.entity.BeneficiaryEntity;
import wilp.dda.vaccinationtool.repository.entity.CenterEntity;
import wilp.dda.vaccinationtool.repository.entity.RegisterEntity;
import wilp.dda.vaccinationtool.repository.entity.VaccineEntity;
import wilp.dda.vaccinationtool.repository.entity.id.RegisterEntityId;
import wilp.dda.vaccinationtool.web.appointment.model.RegisterRequest;

import java.util.Optional;

@Service
public class RegisterService {

    @Autowired
    private RegisterRepository registerRepository;
    @Autowired
    private BeneficiaryRepository beneficiaryRepository;
    @Autowired
    private VaccineRepository vaccineRepository;
    @Autowired
    private CenterRepository centerRepository;

    public void bookAppointment(String userId, RegisterRequest request) {
        Optional<BeneficiaryEntity> beneficiaryEntity = beneficiaryRepository.findById(userId);
        Optional<VaccineEntity> vaccineEntity = vaccineRepository.findById(request.getVaccineid());
        Optional<CenterEntity> centerEntity = centerRepository.findById(request.getCenterid());

        if (beneficiaryEntity.isPresent() && centerEntity.isPresent() && vaccineEntity.isPresent()) {
            registerRepository.save(RegisterEntity.builder()
                    .status(request.getStatus())
                    .date(request.getDate())
                    .beneficiary(beneficiaryEntity.get())
                    .center(centerEntity.get())
                    .id(RegisterEntityId.builder()
                            .bid(userId)
                            .vaccineid(request.getVaccineid())
                            .build())
                    .dosage(request.getDosage())
                    .vaccine(vaccineEntity.get())
                    .build());
        }
    }
}
