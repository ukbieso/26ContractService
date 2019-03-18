package no.ruter.ps.contractService.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import no.ruter.ps.contractService.domainModel.Line;
import no.ruter.ps.contractService.repositories.LineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * en line tjeneste ....
 *
 * @ukbay.gebremeskel@ruter.no
 */

@Service
@AllArgsConstructor
@Slf4j
public class LineService {
    private LineRepository lineRepository;


    public List<Line> getAllLines(){
        return lineRepository.findAll();
    }

    public Optional<Line> getLineByLineNumber(String lineNumber){
        return lineRepository.findByLineNumber(lineNumber);
    }

    public boolean saveLine(Line line){
        Line savedLine = lineRepository.save(line);
        log.info("Line saved : {}", savedLine);
        if(savedLine.getId()!= null && savedLine.getLineNumber().equalsIgnoreCase(line.getLineNumber())){
            return true;
        }
        else
            return false;
    }

}
