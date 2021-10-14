package wilp.dda.vaccinationtool.web.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wilp.dda.vaccinationtool.service.AppointmentService;
import wilp.dda.vaccinationtool.web.appointment.model.AppointmentResponse;
import wilp.dda.vaccinationtool.web.appointment.model.BookAppointmentRequest;
import wilp.dda.vaccinationtool.web.appointment.model.UpdateAppointmentRequest;

import java.util.List;

@RestController
@RequestMapping("/appointment/")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @PostMapping("/")
    public ResponseEntity<?> bookAppointment(@RequestBody BookAppointmentRequest request) {
        service.bookAppointment(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{registrationId}")
    public ResponseEntity<?> updateAppointment(@PathVariable String registrationId, @RequestBody UpdateAppointmentRequest request) {
        service.updateAppointment(registrationId, request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{registrationId}")
    public ResponseEntity<?> getAppointment(@PathVariable String registrationId) {
        AppointmentResponse appointment = service.getAppointment(registrationId);
        return ResponseEntity.ok(appointment);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAppointments() {
        List<AppointmentResponse> appointments = service.getAppointment();
        return ResponseEntity.ok(appointments);
    }
}
