package no.ruter.ps.contractService.domainModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 *
 * @ukbay.gebremeskel@ruter.no
 */

@Data@Builder
@AllArgsConstructor
@Entity
@Table(name = "contracts")
public class Contract {
    @Id@GeneratedValue(generator = "contractId_Generator")
    @SequenceGenerator(name = "contractId_Generator", sequenceName = "id",initialValue = 100)
    private Integer id;
    @Column(name = "") @NotNull
    private String contractName;
    @Column(name = "")@NotNull
    private String operatorName;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "contractId")
    @LazyCollection(LazyCollectionOption.FALSE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<ContractPeriod> contractPeriods;
    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "contractId")
    @LazyCollection(LazyCollectionOption.FALSE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Line> lines;

    protected Contract() {

    }

    public Contract(@NotNull String contractName, @NotNull String operatorName, List<ContractPeriod> contractPeriods, List<Line> lines) {
        this.contractName = contractName;
        this.operatorName = operatorName;
        this.contractPeriods = contractPeriods;
        this.lines = lines;
    }
}
