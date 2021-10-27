package wilp.dda.vaccinationtool.web.beneficiary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wilp.dda.vaccinationtool.service.BeneficiaryService;
import wilp.dda.vaccinationtool.web.beneficiary.model.BeneficiaryResponse;

import java.util.List;

@RestController
@RequestMapping("/beneficiaries/")
public class BeneficiaryController {

    @Autowired
    private BeneficiaryService service;

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserBeneficiaries(@PathVariable String userId) {
        List<BeneficiaryResponse> response = service.getBeneficiaries(userId);
        return ResponseEntity.ok(response);
    }
}
