package wilp.dda.vaccinationtool.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wilp.dda.vaccinationtool.service.BeneficiaryService;
import wilp.dda.vaccinationtool.web.appointment.model.AppointmentResponse;
import wilp.dda.vaccinationtool.web.appointment.model.UpdateAppointmentRequest;
import wilp.dda.vaccinationtool.web.user.model.AddUserRequest;
import wilp.dda.vaccinationtool.web.user.model.SaveUserRequest;
import wilp.dda.vaccinationtool.web.user.model.UserResponse;

import java.util.List;

@RestController
@RequestMapping("/users/")
public class UserController {

    @Autowired
    private BeneficiaryService service;

    @PostMapping("/")
    public ResponseEntity<?> saveUser(@RequestBody SaveUserRequest request) {
        service.saveUser(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable String userId, @RequestBody AddUserRequest request) {
        service.updateUser(userId, request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUser(@PathVariable String userId) {
        UserResponse response = service.getUser(userId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public ResponseEntity<?> getUsers() {
        List<UserResponse> response = service.getUsers();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{userId}/appointments")
    public ResponseEntity<?> getUserAppointments(@PathVariable String userId) {
        List<AppointmentResponse> response = service.getUserAppointments(userId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{userId}/beneficiaries")
    public ResponseEntity<?> getUserBeneficiaries(@PathVariable String userId) {
        List<UserResponse> response = service.getUserBeneficiaries(userId);
        return ResponseEntity.ok(response);
    }

//    @PutMapping("/{userId}/appointments/{appointment}")
//    public ResponseEntity<?> updateAppointment(@PathVariable String registrationId, @RequestBody UpdateAppointmentRequest request) {
//        service.updateAppointment(registrationId, request);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/{userId}/appointments/{appointment}")
//    public ResponseEntity<?> getAppointment(@PathVariable String registrationId) {
//        AppointmentResponse appointment = service.getAppointment(registrationId);
//        return ResponseEntity.ok(appointment);
//    }
}
