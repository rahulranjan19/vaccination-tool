package wilp.dda.vaccinationtool.web.center.vaccine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wilp.dda.vaccinationtool.service.CenterService;
import wilp.dda.vaccinationtool.web.center.vaccine.model.CenterResponse;

import java.util.List;

@RestController
@RequestMapping("/centers/")
public class CenterController {

    @Autowired
    private CenterService service;

    @GetMapping("/{centerId}")
    public ResponseEntity<?> getVaccine(@PathVariable String centerId) {
        CenterResponse response = service.getCenter(centerId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public ResponseEntity<?> getVaccines() {
        List<CenterResponse> responses = service.getAllCenters();
        return ResponseEntity.ok(responses);
    }
}
