package wilp.dda.vaccinationtool.web.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wilp.dda.vaccinationtool.service.RegisterService;
import wilp.dda.vaccinationtool.web.register.model.RegisterResponse;
import wilp.dda.vaccinationtool.web.register.model.RegisterRequest;

import java.util.List;

@RestController
@RequestMapping("/register/")
public class RegisterController {

    @Autowired
    private RegisterService service;

    @PostMapping("/")
    public ResponseEntity<?> bookAppointment(@RequestBody RegisterRequest request) {
        service.bookAppointment(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/")
    public ResponseEntity<?> getAppointments() {
        List<RegisterResponse> appointments = service.getAppointment();
        return ResponseEntity.ok(appointments);
    }
}
