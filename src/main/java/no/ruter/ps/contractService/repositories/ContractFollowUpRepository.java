package no.ruter.ps.contractService.repositories;

import no.ruter.ps.contractService.domainModel.ContractFollowup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 *
 * @ukbay.gebremeskel@ruter.no
 */

@Repository
public interface ContractFollowUpRepository extends JpaRepository<ContractFollowup,Integer> {

}
