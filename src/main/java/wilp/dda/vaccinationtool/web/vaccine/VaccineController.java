package wilp.dda.vaccinationtool.web.vaccine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wilp.dda.vaccinationtool.service.VaccineService;
import wilp.dda.vaccinationtool.web.vaccine.model.VaccineResponse;

import java.util.List;

@RestController
@RequestMapping("/vaccines/")
public class VaccineController {

    @Autowired
    private VaccineService service;

    @GetMapping("/{vaccineId}")
    public ResponseEntity<?> getVaccine(@PathVariable String vaccineId) {
        VaccineResponse response = service.getVaccine(vaccineId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public ResponseEntity<?> getVaccines() {
        List<VaccineResponse> vaccines = service.getAllVaccine();
        return ResponseEntity.ok(vaccines);
    }
}
