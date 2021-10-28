package wilp.dda.vaccinationtool.web.center.vaccine.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import wilp.dda.vaccinationtool.repository.entity.VaccineEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CenterResponse {
    private String name;

    private String centerid;

    private String address1;

    private String address2;

    private String city;

    private String state;

    private Integer pincode;


    private Set<Vaccine> vaccines;
}
