package no.ruter.ps.contractService.service;

import lombok.AllArgsConstructor;
import no.ruter.ps.contractService.domainModel.ContractFollowup;
import no.ruter.ps.contractService.repositories.ContractFollowUpRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * en kontarkt oppfolging tjeneste ....
 *
 * @ukbay.gebremeskel@ruter.no
 */

@Service
@AllArgsConstructor
public class ContractFollowUpService {
    private ContractFollowUpRepository contractFollowUpRepository;


    public List<ContractFollowup> findAllContractFollowUp(){
        return contractFollowUpRepository.findAll();
    }


    public ContractFollowup saveContractFollowUp(ContractFollowup contractFollowUp){
        return contractFollowUpRepository.save(contractFollowUp);
    }

    public Optional<ContractFollowup> findById(Integer id){
        return contractFollowUpRepository.findById(id);
    }

}
