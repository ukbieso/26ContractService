package no.ruter.ps.contractService.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import no.ruter.ps.contractService.domainModel.LineActualDistance;
import no.ruter.ps.contractService.repositories.LineDateDistanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 *
 *
 *@ukbay.gebremeskel@ruter.no
 */

@Service@Slf4j
public class PlaneDataDistanceService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private LineDateDistanceRepository lineDateDistanceRepository;
    @Value("${tps.baseUrl}")
    private String baseUrl;
    @Value("${tps.username}")
    private String tpsUserName;
    @Value("${tps.password}")
    private String tpsPassword;

    private String getQuery(String line, String date){
        log.info("Input data: {}  {}",line,date);
        String query ="{\"query\": \"{lineDate(lineId: \\\"RUT:Line:"+line+"\\\", date: \\\""+date+"\\\") { totalDistance } } \"} " ;
        return  query;
    }

    public float getDateLineDistance(String linePublicCode, String localDate){
        log.info("Input Data line public code : {}  and date : {}", linePublicCode,localDate);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setBasicAuth(tpsUserName,tpsPassword);
        HttpEntity<String> entity =new HttpEntity<String>(getQuery(linePublicCode,localDate),httpHeaders);
        ResponseEntity<Object>  response =restTemplate.exchange(baseUrl, HttpMethod.POST,entity, Object.class);
        Map<String, Object> objcetMap = objectMapper.convertValue(response.getBody(), Map.class);
        Object obj = objcetMap.get("data");
        Map<String, Object> lineDateMap = objectMapper.convertValue(obj,Map.class);
        Object distanceObject = lineDateMap.get("lineDate");
        String distance = distanceObject.toString().split("=")[1];
        if(distance != null && !distance.isEmpty() ){
            LineActualDistance lineActualDistance = new LineActualDistance (linePublicCode,
                    Float.valueOf(distance.substring(0, distance.length()-1)),getDateFromString(localDate));
            lineDateDistanceRepository.save(lineActualDistance);
        }
        return Float.valueOf(distance.substring(0, distance.length()-1));
    }

    private LocalDate getDateFromString(String localDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(localDate);
    }

}
