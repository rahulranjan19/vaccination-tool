package wilp.dda.vaccinationtool.web.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wilp.dda.vaccinationtool.service.RegisterService;
import wilp.dda.vaccinationtool.web.appointment.model.RegisterRequest;

@RestController
@RequestMapping("/appointments/")
public class AppointmentController {

    @Autowired
    private RegisterService service;

    @PostMapping("/{bid}")
    public ResponseEntity<?> bookAppointment(@PathVariable String bid, @RequestBody RegisterRequest request) {
        service.bookAppointment(bid, request);
        return ResponseEntity.ok().build();
    }
}
