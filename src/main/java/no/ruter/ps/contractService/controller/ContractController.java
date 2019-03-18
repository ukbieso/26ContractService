package no.ruter.ps.contractService.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import no.ruter.ps.contractService.dataTransferObjects.ContractDto;
import no.ruter.ps.contractService.dataTransferObjects.ContractPeriodListDto;
import no.ruter.ps.contractService.domainModel.Contract;
import no.ruter.ps.contractService.domainModel.Line;
import no.ruter.ps.contractService.service.ContractService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * en rest kontroller klass og bruks til bare håntere http kontrakt requester
 *
 * @ukbay.gebremeskel@ruter.no
 *
 */
@RestController
@RequestMapping("/api/contracts")
@AllArgsConstructor
@Slf4j
public class ContractController {
    private ContractService contractService;
    private ModelMapper modelMapper;
    @GetMapping()
    public ResponseEntity<List<ContractDto>> getContracts(){
        List<ContractDto> contractDtos = contractService.getAllContracts().stream()
                .map(contract -> {
                    return modelMapper.map(contract,ContractDto.class);
                })
                .collect(Collectors.toList());
        return new ResponseEntity(contractDtos, HttpStatus.OK);
    }

    @GetMapping("/{contractId}")
    public ResponseEntity<Contract> getContractByContractId(@Valid@PathVariable(value = "contractId") Integer id){
        log.info("Input data contractId: {}", id);
        return contractService.getContractByContractId(id).isPresent()?
                new ResponseEntity(contractService.getContractByContractId(id).get(),HttpStatus.OK):
                new ResponseEntity("Contract with contract id: "+ id + " NOT FOUND!",HttpStatus.NOT_FOUND);
    }
    @GetMapping("/contract/{contractName}")
    public ResponseEntity<Contract> getContractByContractName(@Valid@PathVariable(value = "contractName") String contractName){
        log.info("Input data contractName: {}", contractName);
        return contractService.getContractByContractName(contractName).isPresent()?
                new ResponseEntity<>(contractService.getContractByContractName(contractName).get(),HttpStatus.OK):
                new ResponseEntity("contract with contract name: " + contractName + " NOT FOUND!",HttpStatus.NOT_FOUND);
    }

    @PostMapping("/contract")
    public ResponseEntity<String> saveContract(@Valid@RequestBody ContractDto contractDto){
        log.info("Input data contractDto : \n \n {}  \n\n", contractDto);
        List<Line> lines = contractDto.getLines();
        log.info("Lines : \n \n {} \n",lines);
        ContractPeriodListDto contractPeriodListDto = modelMapper.map(contractDto,ContractPeriodListDto.class);
        Contract contract = modelMapper.map(contractDto,Contract.class);
        log.info("#### after modelmapper : \n \n {}  \n\n ######", contract);
        contract.setLines(lines);
        contract.setContractPeriods(contractPeriodListDto.getContractPeriods());
        log.info("After modelMapper : \n contractPeriods: {} \n lines: {} \n contract: {} ",
                contractPeriodListDto.getContractPeriods(), lines, contract );
        boolean isSaved = contractService.saveContract(contract);
        if(isSaved)
        return new ResponseEntity( "successfuly save contract to database", HttpStatus.CREATED);
        else
            return new ResponseEntity("Contract with contract name: "+contract.getContractName()+
                    " found! You can not made a contract with the same contract name!",HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/contract")
    public ResponseEntity<String> changeContract(@Valid @RequestBody ContractDto contractDto){
        log.info("Input data contractDto: {}", contractDto);
        ContractPeriodListDto contractPeriodListDto = modelMapper.map(contractDto,ContractPeriodListDto.class);
        List<Line> lines = contractDto.getLines();
        Contract contract=modelMapper.map(contractDto, Contract.class);
        contract.setContractPeriods(contractPeriodListDto.getContractPeriods());
        contract.setLines(lines);
        log.info("After modelMapper : \n contractPeriods: {} \n lines: {} \n contract: {} ",
                contractPeriodListDto.getContractPeriods(), lines, contract);
        return contractService.changeContractByContractName(contract)?
                new ResponseEntity("Contract successfully changed!",HttpStatus.OK):
                new ResponseEntity("Contract not found!", HttpStatus.NOT_FOUND);
    }




}
