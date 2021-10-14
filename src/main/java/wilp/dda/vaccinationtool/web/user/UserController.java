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
import wilp.dda.vaccinationtool.service.UserService;
import wilp.dda.vaccinationtool.web.appointment.model.AppointmentResponse;
import wilp.dda.vaccinationtool.web.user.model.AddUserRequest;
import wilp.dda.vaccinationtool.web.user.model.SaveUserRequest;
import wilp.dda.vaccinationtool.web.user.model.UserResponse;

import java.util.List;

@RestController
@RequestMapping("/users/")
public class UserController {

    @Autowired
    private UserService service;

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
    public ResponseEntity<?> getUserAppointment(@PathVariable String userId) {
        List<AppointmentResponse> response = service.getUserAppointments(userId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{userId}/beneficiary")
    public ResponseEntity<?> getUserBeneficiary(@PathVariable String userId) {
        List<UserResponse> response = service.getUserBeneficiary(userId);
        return ResponseEntity.ok(response);
    }
}
