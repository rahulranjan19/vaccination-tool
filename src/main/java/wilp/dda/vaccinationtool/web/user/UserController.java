package wilp.dda.vaccinationtool.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wilp.dda.vaccinationtool.service.BeneficiaryService;
import wilp.dda.vaccinationtool.web.user.model.AddBeneficiaryRequest;
import wilp.dda.vaccinationtool.web.user.model.UserResponse;

@RestController
@RequestMapping("/users/")
public class UserController {

    @Autowired
    private BeneficiaryService service;

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUser(@PathVariable String userId) {
        UserResponse response = service.getUser(userId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{userId}/beneficiaries")
    public ResponseEntity<?> getBeneficiaries(@PathVariable String userId) {
        UserResponse response = service.getBeneficiary(userId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{userId}/beneficiaries")
    public ResponseEntity<?> addBeneficiaries(@PathVariable String userId, @RequestBody AddBeneficiaryRequest request) {
        service.addBeneficiary(userId, request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/signup")
    public ResponseEntity<?> addUser(@RequestBody AddBeneficiaryRequest request) {
        service.addUser(request);
        return ResponseEntity.ok().build();
    }
}
