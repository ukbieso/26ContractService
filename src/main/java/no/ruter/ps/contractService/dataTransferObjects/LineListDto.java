package no.ruter.ps.contractService.dataTransferObjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import no.ruter.ps.contractService.domainModel.Line;

import java.util.List;


/**
 *
 *
 * @ukbay.gebremeskel@ruter.no
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineListDto {
    private List<Line> lineList;

}
