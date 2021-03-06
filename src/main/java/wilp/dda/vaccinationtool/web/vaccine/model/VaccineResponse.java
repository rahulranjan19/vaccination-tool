package wilp.dda.vaccinationtool.web.vaccine.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VaccineResponse {
    private String name;

    private String vaccineid;

    private String manufacturer;

    private Double cost;

    private Set<Center> centers;
}
