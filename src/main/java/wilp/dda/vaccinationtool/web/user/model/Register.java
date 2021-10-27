package wilp.dda.vaccinationtool.web.user.model;

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
public class Register {

    private String status;

    private Instant date;

    private Integer dosage;

    private Vaccine vaccine;

    private Center center;
}
