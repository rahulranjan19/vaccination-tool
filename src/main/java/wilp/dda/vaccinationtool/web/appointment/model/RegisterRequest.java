package wilp.dda.vaccinationtool.web.appointment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {

    private String vaccineid;

    private String centerid;

    private String status;

    private Instant date;

    private Integer dosage;
}
