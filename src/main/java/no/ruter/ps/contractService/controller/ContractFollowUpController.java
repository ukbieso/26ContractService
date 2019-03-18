package no.ruter.ps.contractService.controller;

import lombok.AllArgsConstructor;
import no.ruter.ps.contractService.domainModel.ContractFollowup;
import no.ruter.ps.contractService.service.ContractFollowUpService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * en rest kontroller klass og bruks til bare håntere http kontrakt oppfolging requester
 *
 * @ukbay.gebremeskel@ruter.no
 */

@RestController
@RequestMapping("/api/cfu")
@AllArgsConstructor
public class ContractFollowUpController {

    private ContractFollowUpService contractFollowUpService;

    @GetMapping()
    public ResponseEntity<List<ContractFollowup>> getAllContractFollowUp(){
        return new ResponseEntity(contractFollowUpService.findAllContractFollowUp(), HttpStatus.OK);
    }

    @GetMapping("/{contractFollowUpId}")
    public ResponseEntity<ContractFollowup> getContractFollowUpById(
            @PathVariable(value = "contractFollowUpId") Integer id){
        return new ResponseEntity(contractFollowUpService.findById(id),HttpStatus.OK);
    }

}
