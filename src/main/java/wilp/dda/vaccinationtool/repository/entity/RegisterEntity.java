package wilp.dda.vaccinationtool.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import wilp.dda.vaccinationtool.repository.entity.id.RegisterEntityId;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Builder
@Table(name = "register")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegisterEntity  implements Serializable {

    @EmbeddedId
    private RegisterEntityId id;

    @Column
    private String status;

    @Column
    private Instant date;

    @Column
    private Integer dosage;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bid", referencedColumnName = "bid", insertable = false, updatable = false)
    private BeneficiaryEntity beneficiary;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vaccineid", referencedColumnName = "vaccineid", insertable = false, updatable = false)
    private VaccineEntity vaccine;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "centerid", referencedColumnName = "centerid")
    private CenterEntity center;
}
