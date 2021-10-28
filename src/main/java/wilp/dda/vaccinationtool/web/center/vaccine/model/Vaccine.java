package wilp.dda.vaccinationtool.web.center.vaccine.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vaccine {

    private String name;

    private String vaccineid;

    private String manufacturer;

    private Double cost;
}
