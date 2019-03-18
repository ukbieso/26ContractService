package no.ruter.ps.contractService.domainModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 *
 * @ukbay.gebremeskel@ruter.no
 */

@Embeddable
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class ActualDistanceData {
    @Column(name = "")
    private String actualDistanceInKM;
    @Column(name = "")
    private String actualCalculatedInPercent;
    @Column(name = "")
    private String missedDistanceInPercent;
}
