package wilp.dda.vaccinationtool.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment/")
public class AppointmentController {

    @PostMapping("/{registrationId}")
    public ResponseEntity<?> bookAppointment() {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{registrationId}")
    public ResponseEntity<?> updateAppointment() {
        return ResponseEntity.ok().build();
    }
}
