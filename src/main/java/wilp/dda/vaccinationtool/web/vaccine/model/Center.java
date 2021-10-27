package wilp.dda.vaccinationtool.web.vaccine.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Center {

    private String name;

    private String centerid;

    private String address1;

    private String address2;

    private String city;

    private String state;

    private Integer pincode;
}
