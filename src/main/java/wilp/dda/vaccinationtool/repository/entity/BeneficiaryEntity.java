package wilp.dda.vaccinationtool.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

@Entity
@Builder
@Table(name = "beneficiary")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BeneficiaryEntity implements Serializable {

    @Id
    @Column
    private String bid;

    @Column
    private Instant dob;

    @Column
    private String signedup;

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
    private String govid;

    @Column
    private String govidtype;

    @Column
    private String parentid;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "parentid")
    private Set<BeneficiaryEntity> beneficiaries;

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

    @OneToMany(mappedBy = "beneficiary", fetch = FetchType.EAGER)
    private Set<RegisterEntity> registrations;
}
