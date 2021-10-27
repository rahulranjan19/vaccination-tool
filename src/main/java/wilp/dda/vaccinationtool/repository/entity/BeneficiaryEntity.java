package wilp.dda.vaccinationtool.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Builder
@Table(name = "beneficiary")
@NoArgsConstructor
@AllArgsConstructor
public class BeneficiaryEntity {

    @Id
    @Column(name="mobile_number")
    private String mobileNumber;

    @Column
    private Timestamp dob;

    @Column
    private String userid;

    @Column
    private String pwd;

    @Column
    private String fname;

    @Column
    private String mname;

    @Column
    private String lname;

    @Column
    private String gender;

    @Column
    private String id;

    @Column
    private String muserid;

    @Column
    private String add1;

    @Column
    private String add2;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private Integer pincode;
}
