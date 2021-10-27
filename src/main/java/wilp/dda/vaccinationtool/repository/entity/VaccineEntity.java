package wilp.dda.vaccinationtool.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Builder
@Table(name = "vaccine")
@NoArgsConstructor
@AllArgsConstructor
public class VaccineEntity {

    @Column
    private String name;

    @Id
    private String vaccineid;

    @Column
    private String manufacturer;

    @Column
    private Double cost;

    @ManyToMany(mappedBy = "vaccines")
    private Set<CenterEntity> centers;
}
