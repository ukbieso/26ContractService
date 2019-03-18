package no.ruter.ps.contractService.dataTransferObjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import no.ruter.ps.contractService.domainModel.Line;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 *
 *
 * @ukbay.gebremeskel@ruter.no
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractDto {
    private Integer id;
    @NotBlank(message = "Contract name can not be null or empty")
    @NotNull(message = "Contract name can not be null or empty")
    private String contractName;
    @NotBlank(message = "Operator name can not be null or empty")
    @NotNull(message = "Operator name can not be null or empty")
    private String operatorName;
    @NotNull
    private List<ContractPeriodDto> contractPeriods;
    @NotNull(message = "Line or lines can not be null or empty")
    private List<Line> lines;
}
