package wilp.dda.vaccinationtool.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import wilp.dda.vaccinationtool.repository.BeneficiaryRepository;
import wilp.dda.vaccinationtool.repository.RegisterRepository;
import wilp.dda.vaccinationtool.repository.entity.BeneficiaryEntity;
import wilp.dda.vaccinationtool.repository.entity.CenterEntity;
import wilp.dda.vaccinationtool.repository.entity.RegisterEntity;
import wilp.dda.vaccinationtool.repository.entity.VaccineEntity;
import wilp.dda.vaccinationtool.web.user.model.AddBeneficiaryRequest;
import wilp.dda.vaccinationtool.web.user.model.Center;
import wilp.dda.vaccinationtool.web.user.model.Register;
import wilp.dda.vaccinationtool.web.user.model.UserResponse;
import wilp.dda.vaccinationtool.web.user.model.Vaccine;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Service
public class BeneficiaryService {

    @Autowired
    private BeneficiaryRepository beneficiaryRepository;

    @Autowired
    private RegisterRepository registerRepository;

    public UserResponse getUser(String userId) {
        Optional<BeneficiaryEntity> userOpt = beneficiaryRepository.findById(userId);
        if (userOpt.isPresent()) {
            BeneficiaryEntity beneficiaryEntity = userOpt.get();
            if (Objects.isNull(beneficiaryEntity.getSignedup())) {
                return null;
            }

            return getUserResponse(beneficiaryEntity);
        }

        return null;
    }

    public UserResponse getBeneficiary(String userId) {
        Optional<BeneficiaryEntity> userOpt = beneficiaryRepository.findById(userId);
        if (userOpt.isPresent()) {
            BeneficiaryEntity beneficiaryEntity = userOpt.get();
            return getUserResponse(beneficiaryEntity);
        }

        return null;
    }

    private UserResponse getUserResponse(BeneficiaryEntity beneficiaryEntity) {
        return UserResponse.builder()
                .pincode(beneficiaryEntity.getPincode())
                .add1(beneficiaryEntity.getAdd1())
                .add2(beneficiaryEntity.getAdd2())
                .bid(beneficiaryEntity.getBid())
                .dob(beneficiaryEntity.getDob())
                .city(beneficiaryEntity.getCity())
                .fname(beneficiaryEntity.getFname())
                .gender(beneficiaryEntity.getGender())
                .govid(beneficiaryEntity.getGovid())
                .govidtype(beneficiaryEntity.getGovidtype())
                .lname(beneficiaryEntity.getLname())
                .mname(beneficiaryEntity.getMname())
                .pwd(beneficiaryEntity.getPwd())
                .parentid(beneficiaryEntity.getParentid())
                .signedup(beneficiaryEntity.getSignedup())
                .state(beneficiaryEntity.getState())
                .beneficiaries(CollectionUtils.isEmpty(beneficiaryEntity.getBeneficiaries())
                        ? null
                        : beneficiaryEntity.getBeneficiaries().stream().map(this::getUserResponse).collect(Collectors.toSet()))
                .registrations(CollectionUtils.isEmpty(beneficiaryEntity.getRegistrations())
                        ? null
                        : beneficiaryEntity.getRegistrations().stream().map(this::getRegistration).collect(Collectors.toSet()))
                .build();
    }

    private Register getRegistration(RegisterEntity registerEntity) {
        return Register.builder()
                .center(this.getCenter(registerEntity.getCenter()))
                .date(registerEntity.getDate())
                .dosage(registerEntity.getDosage())
                .status(registerEntity.getStatus())
                .vaccine(this.getVaccine(registerEntity.getVaccine()))
                .build();
    }

    private Vaccine getVaccine(VaccineEntity vaccine) {
        return Vaccine.builder()
                .vaccineid(vaccine.getVaccineid())
                .cost(vaccine.getCost())
                .manufacturer(vaccine.getManufacturer())
                .name(vaccine.getName())
                .build();
    }

    private Center getCenter(CenterEntity center) {
        return Center.builder()
                .centerid(center.getCenterid())
                .address1(center.getAddress1())
                .address2(center.getAddress2())
                .name(center.getName())
                .city(center.getCity())
                .state(center.getState())
                .pincode(center.getPincode())
                .build();
    }

    public void addBeneficiary(String userId, AddBeneficiaryRequest request) {
        beneficiaryRepository.save(getBeneficiaryEntity(userId, request));
    }

    private BeneficiaryEntity getBeneficiaryEntity(String userId, AddBeneficiaryRequest request) {
        return BeneficiaryEntity.builder()
                .pincode(request.getPincode())
                .add1(request.getAdd1())
                .add2(request.getAdd2())
                .bid(request.getBid())
                .dob(request.getDob())
                .city(request.getCity())
                .fname(request.getFname())
                .gender(request.getGender())
                .govid(request.getGovid())
                .govidtype(request.getGovidtype())
                .lname(request.getLname())
                .mname(request.getMname())
                .pwd(request.getPwd())
                .parentid(userId)
                .signedup(request.getSignedup())
                .state(request.getState())
                .build();
    }

    public void addUser(AddBeneficiaryRequest request) {
        Optional<BeneficiaryEntity> beneficiaryEntityDBOpt = beneficiaryRepository.findById(request.getBid());

        if (beneficiaryEntityDBOpt.isPresent()) {
            BeneficiaryEntity beneficiaryEntity = beneficiaryEntityDBOpt.get();
            beneficiaryEntity.setPwd(request.getPwd());
            beneficiaryEntity.setSignedup("true");
            beneficiaryRepository.save(beneficiaryEntity);
            return;
        }

        BeneficiaryEntity beneficiaryEntityNew = getBeneficiaryEntity(null, request);
        beneficiaryRepository.save(beneficiaryEntityNew);
    }
}
