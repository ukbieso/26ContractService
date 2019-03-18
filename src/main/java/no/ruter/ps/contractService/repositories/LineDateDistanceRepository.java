package no.ruter.ps.contractService.repositories;

import no.ruter.ps.contractService.domainModel.LineActualDistance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *
 *
 * @ukbay.gebremeskel@ruter.no
 */

@Repository
public interface LineDateDistanceRepository extends JpaRepository<LineActualDistance,Integer> {
    Optional<LineActualDistance> findByLinePublicCode(String linePublicCode);
}
