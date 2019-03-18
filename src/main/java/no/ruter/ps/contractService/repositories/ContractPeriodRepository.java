package no.ruter.ps.contractService.repositories;

import no.ruter.ps.contractService.domainModel.ContractPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 *
 * @ukbay.gebremeskel@ruter.no
 */

@Repository
public interface ContractPeriodRepository extends JpaRepository<ContractPeriod,Integer> {
}
