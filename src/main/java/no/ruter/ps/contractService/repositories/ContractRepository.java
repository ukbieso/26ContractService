package no.ruter.ps.contractService.repositories;

import no.ruter.ps.contractService.domainModel.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *
 *
 * @ukbay.gebremeskel@ruter.no
 */

@Repository
public interface ContractRepository extends JpaRepository<Contract,Integer> {
    Optional<Contract> findByContractName(String contractName);
}
