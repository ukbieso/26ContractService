package no.ruter.ps.contractService.dataTransferObjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 *
 * @ukbay.gebremeskel@ruter.no
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractResponseDto {
    private String contractNumber;
    private String contractName;
    private String operatorName;
    private String validityPeriod;
    private String lines;
    private String totalDistanceInKM;
    private String distanceInKMEveryDay;
    private String distanceInKMEveryDaySchool;
    private String distanceInKMSaturday;
    private String distanceInKMSunday;
    private String productionRequiredInPercent;
    private String plannedFeePerMissedInPercent;
    private String plannedRequiredDistanceInKM;
    private String actualDistanceInKM;
    private String actualCalculatedInPercent;
    private String missedDistanceInPercent;
    private long totalFee;
    private String reasoningFromOperator;
    private String reasoningApproved;
}
