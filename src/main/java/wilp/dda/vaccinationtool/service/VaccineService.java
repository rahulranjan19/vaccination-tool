package wilp.dda.vaccinationtool.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import wilp.dda.vaccinationtool.repository.VaccineRepository;
import wilp.dda.vaccinationtool.repository.entity.CenterEntity;
import wilp.dda.vaccinationtool.repository.entity.VaccineEntity;
import wilp.dda.vaccinationtool.web.vaccine.model.Center;
import wilp.dda.vaccinationtool.web.vaccine.model.VaccineResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class VaccineService {

    @Autowired
    private VaccineRepository repository;

    public VaccineResponse getVaccine(String vaccineId) {
        Optional<VaccineEntity> vaccineOpt = repository.findById(vaccineId);
        if (vaccineOpt.isPresent()) {
            VaccineEntity vaccineEntity = vaccineOpt.get();
            return getVaccine(vaccineEntity);
        }

        return null;
    }

    private VaccineResponse getVaccine(VaccineEntity vaccineEntity) {
        return VaccineResponse.builder()
                .vaccineid(vaccineEntity.getVaccineid())
                .cost(vaccineEntity.getCost())
                .manufacturer(vaccineEntity.getManufacturer())
                .name(vaccineEntity.getName())
                .centers(CollectionUtils.isEmpty(vaccineEntity.getCenters()) ? null : vaccineEntity.getCenters().stream().map(this::getCenter).collect(Collectors.toSet()))
                .build();
    }

    private Center getCenter(CenterEntity centerEntity) {
        return Center.builder()
                .centerid(centerEntity.getCenterid())
                .address1(centerEntity.getAddress1())
                .address2(centerEntity.getAddress2())
                .city(centerEntity.getCity())
                .name(centerEntity.getName())
                .pincode(centerEntity.getPincode())
                .state(centerEntity.getState())
                .build();
    }

    public List<VaccineResponse> getAllVaccine() {
        Iterable<VaccineEntity> vaccineEntities = repository.findAll();

        if (vaccineEntities.iterator().hasNext()) {
            List<VaccineResponse> vaccineResponses = new ArrayList<>();
            vaccineEntities.forEach(vaccineEntity -> vaccineResponses.add(getVaccine(vaccineEntity)));
            return vaccineResponses;
        }
        return null;
    }
}
