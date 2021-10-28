package wilp.dda.vaccinationtool.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import wilp.dda.vaccinationtool.repository.CenterRepository;
import wilp.dda.vaccinationtool.repository.entity.CenterEntity;
import wilp.dda.vaccinationtool.repository.entity.VaccineEntity;
import wilp.dda.vaccinationtool.web.center.vaccine.model.CenterResponse;
import wilp.dda.vaccinationtool.web.center.vaccine.model.Vaccine;
import wilp.dda.vaccinationtool.web.vaccine.model.VaccineResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CenterService {

    @Autowired
    private CenterRepository repository;

    public CenterResponse getCenter(String centerId) {
        Optional<CenterEntity> centerOpt = repository.findById(centerId);
        if (centerOpt.isPresent()) {
            CenterEntity centerEntity = centerOpt.get();
            return getCenterResponse(centerEntity);
        }

        return null;
    }

    private Vaccine getVaccine(VaccineEntity vaccineEntity) {
        return Vaccine.builder()
                .vaccineid(vaccineEntity.getVaccineid())
                .cost(vaccineEntity.getCost())
                .manufacturer(vaccineEntity.getManufacturer())
                .name(vaccineEntity.getName())
                .build();
    }

    private CenterResponse getCenterResponse(CenterEntity centerEntity) {
        return CenterResponse.builder()
                .centerid(centerEntity.getCenterid())
                .address1(centerEntity.getAddress1())
                .address2(centerEntity.getAddress2())
                .city(centerEntity.getCity())
                .name(centerEntity.getName())
                .pincode(centerEntity.getPincode())
                .state(centerEntity.getState())
                .vaccines(CollectionUtils.isEmpty(centerEntity.getVaccines()) ? null : centerEntity.getVaccines().stream().map(this::getVaccine).collect(Collectors.toSet()))
                .build();
    }

    public List<CenterResponse> getAllCenters() {
        Iterable<CenterEntity> centerEntities = repository.findAll();

        if (centerEntities.iterator().hasNext()) {
            List<CenterResponse> centerResponses = new ArrayList<>();
            centerEntities.forEach(vaccineEntity -> centerResponses.add(getCenterResponse(vaccineEntity)));
            return centerResponses;
        }
        return null;
    }
}
