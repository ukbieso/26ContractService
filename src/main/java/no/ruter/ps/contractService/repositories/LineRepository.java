package no.ruter.ps.contractService.repositories;

import no.ruter.ps.contractService.domainModel.Line;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *
 *
 * @ukbay.gebremeskel@ruter.no
 */

@Repository
public interface LineRepository extends JpaRepository<Line,Integer> {

    Optional<Line> findByLineNumber(String lineNumber);
}
