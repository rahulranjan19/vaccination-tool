package wilp.dda.vaccinationtool.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wilp.dda.vaccinationtool.repository.VaccineRepository;
import wilp.dda.vaccinationtool.web.vaccine.model.VaccineResponse;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class VaccineService {

    @Autowired
    private VaccineRepository repository;

    public VaccineResponse getVaccine(String vaccineId) {
        repository.findById(vaccineId);
        return VaccineResponse.builder().build();
    }

    public List<VaccineResponse> getAllVaccine() {
        repository.findAll();
        return new ArrayList<>();
    }
}
