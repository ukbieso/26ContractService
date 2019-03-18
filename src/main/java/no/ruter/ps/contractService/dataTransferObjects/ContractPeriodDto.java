package no.ruter.ps.contractService.dataTransferObjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractPeriodDto {
    @NotNull
    private String fromLocalDate;
    @NotNull
    private String toLocalDate;
    @NotNull@Max(value = 1, message = "Production required in percent can not be more than 100%, Allowed values are between 1 - 0")
    @Min(value = 0, message ="Production required in percent can not be less than 0%, Allowed values are between 1 - 0" )
    private double productionRequired;
    @NotNull
    private double feePerMissedInPercentPoint;
}
