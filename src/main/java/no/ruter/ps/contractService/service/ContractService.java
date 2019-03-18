package no.ruter.ps.contractService.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import no.ruter.ps.contractService.domainModel.Contract;
import no.ruter.ps.contractService.repositories.ContractPeriodRepository;
import no.ruter.ps.contractService.repositories.ContractRepository;
import no.ruter.ps.contractService.repositories.LineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * en kontarkt tjeneste ....
 *
 * @ukbay.gebremeskel@ruter.no
 */

@Service
@AllArgsConstructor
@Slf4j
public class ContractService {
    private ContractRepository contractRepository;
    private LineRepository lineRepository;
    private ContractPeriodRepository contractPeriodRepository;
    /**
     * hents alle kontrakter fra database
     *
     * @return
     */
    public List<Contract> getAllContracts() {
        return contractRepository.findAll();
    }

    /**
     * hents et kontrakt etter søking med gitt kontrak Id, hvis det finnes
     *
     * @param contractId
     * @return
     */
    public Optional<Contract> getContractByContractId(Integer contractId) {
        return contractRepository.findById(contractId);
    }

    /**
     * hents et kontrakt etter søking med gitt kontrakt nummer, hvis det finnes
     *
     * @param contractName
     * @return
     */
    public Optional<Contract> getContractByContractName(String contractName) {
        return contractRepository.findByContractName(contractName);
    }

    /**
     * bruks til å lagre en kontrak
     *
     * @param contract
     */
    public boolean saveContract(Contract contract) {
        if(!contractRepository.findByContractName(contract.getContractName()).isPresent()){
            Contract savedContract =contractRepository.save(contract);
            log.info("saved contract : {}", savedContract);
            return true;
        }
        log.info("Contract with contract name : {} is already there. You can not create contract with the same contract name" );
        return false;
    }

    /**
     * bruks til å lagre en bulk kontrakts
     *
     * @param contractList
     */
    public String saveListOfContracts(List<Contract> contractList) {
        contractRepository.saveAll(contractList);
        return "Contract lists successuflly saved!";
    }

    /**
     * bruks til redigering av en kontrakt
     * @param contract
     * @return
     */

    public boolean changeContractByContractName(Contract contract){
        if(contractRepository.getOne(contract.getId()) !=  null){
            Contract oldContract = contractRepository.getOne(contract.getId());
            log.info("oldContractObject: {} ",oldContract);
                oldContract = contract;
                Contract afterupdate = contractRepository.saveAndFlush(oldContract);
                log.info("Updated contract : {}",afterupdate);
                return true;
        }
        return false;
    }

}