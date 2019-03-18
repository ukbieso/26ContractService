package no.ruter.ps.contractService.dataTransferObjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import no.ruter.ps.contractService.domainModel.ContractPeriod;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractPeriodListDto {
    private List<ContractPeriod> contractPeriods;
}
