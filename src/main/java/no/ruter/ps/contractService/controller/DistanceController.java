package no.ruter.ps.contractService.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import no.ruter.ps.contractService.service.ActualDataElasticsearchServices;
import no.ruter.ps.contractService.service.PlaneDataDistanceService;
import org.springframework.web.bind.annotation.*;

/**
 * Only used to test will be deleted afterward
 */

@RestController
@RequestMapping("/api/dis")
@Slf4j
@AllArgsConstructor
public class DistanceController {
    private PlaneDataDistanceService planeDataService;
    private ActualDataElasticsearchServices actualDataElasticsearchServices;

    @PostMapping("{line}/{date}")
    public float getdisnace(@PathVariable(value = "line")String line, @PathVariable(value = "date")String date){
        return planeDataService.getDateLineDistance(line,date);
    }

    @GetMapping("index")
    public String initializeIndex(){
        actualDataElasticsearchServices.createIndexAndSave();
        return "index init";
    }


}
