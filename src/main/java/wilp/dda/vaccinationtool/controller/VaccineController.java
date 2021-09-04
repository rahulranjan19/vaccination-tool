package wilp.dda.vaccinationtool.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vaccines/")
public class VaccineController {

    @GetMapping("/{vaccineId}")
    public ResponseEntity<?> getVaccine() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/")
    public ResponseEntity<?> getVaccines() {
        return ResponseEntity.ok().build();
    }
}
