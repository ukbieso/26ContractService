package no.ruter.ps.contractService.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import no.ruter.ps.contractService.dataTransferObjects.LineListDto;
import no.ruter.ps.contractService.domainModel.Line;
import no.ruter.ps.contractService.service.LineService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 *
 * en rest kontroller klass og bruks til bare håntere http line requester
 *
 * @ukbay.gebremeskel@ruter.no
 *
 */

@RestController
@RequestMapping("/api/lines")
@AllArgsConstructor
@Slf4j
public class LineController {
    private LineService lineService;


    @GetMapping()
    public ResponseEntity<List<Line>> getAllLines(){
        return new ResponseEntity(lineService.getAllLines(), HttpStatus.OK);
    }

    @GetMapping("/line/{lineNumber}")
    public ResponseEntity<Line> getLineByLineNumber(@Valid @PathVariable(value = "lineNumber") String linenumber){
        log.info("Input data  lineNumber : {}", linenumber);
        return new ResponseEntity(lineService.getLineByLineNumber(linenumber).get(),HttpStatus.OK);
    }

}
