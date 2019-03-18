package no.ruter.ps.contractService.dataTransferObjects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 *
 * @ukbay.gebremeskel@ruter.no
 */

public class ContractFollowUpDto {
    @NotBlank(message = "Contract number can not be null or empty")
    @NotNull(message = "Contract number can not be null or empty")
    private String contractNumber;
    @NotBlank(message = "Contract name can not be null or empty")
    @NotNull(message = "Contract name can not be null or empty")
    private String contractName;
    @NotBlank(message = "Operator name can not be null or empty")
    @NotNull(message = "Operator name can not be null or empty")
    private String operatorName;
    private String validityPeriod;
    private String contractPhase;
    private String fromLocalDate;
    private String toLocalDate;
    @NotBlank(message = "Line or lines can not be null or empty")
    @NotNull(message = "Line or lines can not be null or empty")
    private String lineNumber;
    private String lineName;
    private String totalDistanceInKM;
    @NotBlank(message = "ProductionRequiredInPercent  can not be null or empty")
    @NotNull(message = "pOoductionRequiredInPercent can not be null or empty")
    private String productionRequiredInPercent;
    @NotBlank(message = "plannedFeePerMissedInPercentPoint can not be null or empty")
    @NotNull(message = "plannedFeePerMissedInPercentPoint can not be null or empty")
    private String plannedFeePerMissedInPercentPoint;
    private String reasoningFromOperator;
    private String reasoningApproved;
}
