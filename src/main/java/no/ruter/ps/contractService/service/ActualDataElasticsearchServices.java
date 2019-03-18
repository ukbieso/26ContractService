package no.ruter.ps.contractService.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import no.ruter.ps.contractService.repositories.ContractRepository;
import no.ruter.ps.contractService.repositories.LineDateDistanceRepository;
import no.ruter.ps.contractService.repositories.LineRepository;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * en t
 *
 * @ukbay.gebremeskel@ruter.no
 */

@Service
@Slf4j
public class ActualDataElasticsearchServices {
    private RestHighLevelClient restHighLevelClient;
    private LineDateDistanceRepository lineDateDistanceRepository;
    private LineRepository lineRepository;
    private ContractRepository contractRepository;
    private ObjectMapper objectMapper;
    @Value("${elasticsearch.index.name}")
    private String indexName;
    @Value("${elasticsearch.index.type}")
    private String estype;
    @Autowired
    public ActualDataElasticsearchServices(RestHighLevelClient restHighLevelClient,
                                           LineDateDistanceRepository lineDateDistanceRepository,
                                           ObjectMapper objectMapper) {
        this.restHighLevelClient = restHighLevelClient;
        this.lineDateDistanceRepository = lineDateDistanceRepository;
        this.objectMapper = objectMapper;
    }


    public void createIndexAndSave(){

        lineDateDistanceRepository.findAll().forEach(ptd -> {
            try {
                UUID uuid = UUID.randomUUID();
                log.info("The line contract connection: {}",lineRepository.findByLineNumber(ptd.getLinePublicCode()));
                Map<String, Object> actualDistanceMap = objectMapper.convertValue(ptd, Map.class);
                log.info("date line distance: {}",actualDistanceMap);
                IndexRequest request = new IndexRequest(indexName, estype, uuid.toString()).source(actualDistanceMap);
                IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);
                log.info("Status: {}",response.getResult().name());
            } catch (IOException e){
                log.error("Error message: {}", e.getMessage());
            }
        });

    }
}
