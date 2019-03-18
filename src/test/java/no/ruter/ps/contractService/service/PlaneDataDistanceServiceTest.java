package no.ruter.ps.contractService.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.ruter.ps.contractService.repositories.LineDateDistanceRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@Ignore
public class PlaneDataDistanceServiceTest {

    @InjectMocks
    private PlaneDataDistanceService planeDataDistanceService;
    @Mock
    private RestTemplate restTemplate;
    @Mock
    private ObjectMapper objectMapper;
    @Mock
    private LineDateDistanceRepository lineDateDistanceRepository;
    @Value("${tps.baseUrl}")
    private String baseUrl;
    @Value("${tps.username:ruter}")
    private String tpsUserName;
    @Value("${tps.password:crimson}")
    private String tpsPassword;

    @Before
    public void setup(){

    }

    @Test
    public void shouldCalculateDistancePerGiveDateAndPublicLineCode(){
        String date = "2019-03-11";
        String line = "310";
        float result = planeDataDistanceService.getDateLineDistance(line,date);
        Assert.assertNotNull(result);
        Assert.assertEquals(result, 1695599.900000014);
    }
    }
