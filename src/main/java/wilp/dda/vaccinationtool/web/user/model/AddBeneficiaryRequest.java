package wilp.dda.vaccinationtool.web.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddBeneficiaryRequest {

    private String bid;


    private Instant dob;


    private String signedup;


    private String pwd;


    private String fname;


    private String mname;


    private String lname;


    private String gender;


    private String govid;


    private String govidtype;


    private String add1;


    private String add2;


    private String city;


    private String state;


    private Integer pincode;
}
