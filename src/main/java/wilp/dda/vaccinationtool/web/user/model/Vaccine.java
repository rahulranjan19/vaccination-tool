package wilp.dda.vaccinationtool.web.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vaccine {

    private String name;

    private String vaccineid;

    private String manufacturer;

    private Double cost;
}
