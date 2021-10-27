package wilp.dda.vaccinationtool.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Entity
@Builder
@Table(name = "center")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CenterEntity  implements Serializable {

    @Column
    private String name;

    @Id
    private String centerid;

    @Column
    private String address1;

    @Column
    private String address2;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private Integer pincode;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "center_vaccine",
            joinColumns = {@JoinColumn(name = "centerid")},
            inverseJoinColumns = {@JoinColumn(name = "vaccineid")}
    )
    private Set<VaccineEntity> vaccines;
}
