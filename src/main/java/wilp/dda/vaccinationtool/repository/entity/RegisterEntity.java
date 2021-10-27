package wilp.dda.vaccinationtool.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import wilp.dda.vaccinationtool.repository.entity.id.RegisterEntityId;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Builder
@Table(name = "register")
@NoArgsConstructor
@AllArgsConstructor
public class RegisterEntity {

    @EmbeddedId
    private RegisterEntityId id;

    @Column
    private String status;

    @Column
    private Timestamp date;

    @Column
    private Integer dosage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bid", referencedColumnName = "mobile_number", insertable = false, updatable = false)
    private BeneficiaryEntity beneficiary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vaccineid", referencedColumnName = "vaccineid", insertable = false, updatable = false)
    private VaccineEntity vaccine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "centerid", referencedColumnName = "centerid")
    private CenterEntity center;
}
