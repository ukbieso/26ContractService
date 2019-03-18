package no.ruter.ps.contractService.domainModel;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 *
 *
 * @ukbay.gebremeskel@ruter.no
 */

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "contract_periods")
public class ContractPeriod {
    @Id
    @GeneratedValue(generator = "ContractPeriod_Generator")
    @SequenceGenerator(name = "ContractPeriod_Generator", sequenceName = "contractPeriod_Id",initialValue = 100)
    private Integer id;
    @Column(name = "")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE )
    private LocalDate fromLocalDate;
    @Column(name = "")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate toLocalDate;
    @Column(name = "")@NotNull
    private double productionRequired;
    @Column(name = "") @NotNull
    private double feePerMissedInPercentPoint;

    public ContractPeriod(LocalDate fromLocalDate, LocalDate toLocalDate, @NotNull double productionRequired, @NotNull double feePerMissedInPercentPoint) {
        this.fromLocalDate = fromLocalDate;
        this.toLocalDate = toLocalDate;
        this.productionRequired = productionRequired;
        this.feePerMissedInPercentPoint = feePerMissedInPercentPoint;
    }


}
