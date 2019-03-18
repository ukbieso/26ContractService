package no.ruter.ps.contractService.service;

import no.ruter.ps.contractService.domainModel.ContractFollowup;
import no.ruter.ps.contractService.repositories.ContractFollowUpRepository;
import no.ruter.ps.contractService.testUtilles.ContractTestUtiles;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ContractFollowUpServiceTest {
    @InjectMocks
    private ContractFollowUpService contractFollowUpService;
    @Mock
    private ContractFollowUpRepository contractFollowUpRepository;

    private List<ContractFollowup> contractFollowupList;
    private ContractFollowup contractFollowup;

    @Before
    public void setUp(){
        contractFollowup = ContractTestUtiles.getContractFollowupWithId();
        contractFollowupList = new ArrayList<>();
        contractFollowupList.add(contractFollowup);
    }

    /// *************************** GET ALL CONTRACT-FOLLOWUP SERVICE  ******************************************** ///
    @Test
    public void shouldReturnAllContractFolloup(){
        when(contractFollowUpRepository.findAll()).thenReturn(contractFollowupList);
        List<ContractFollowup> result = contractFollowUpService.findAllContractFollowUp();
        Assert.assertNotNull(result);
        Assert.assertEquals(result.get(0).getContractName(),ContractTestUtiles.contractName);
    }

    /// *************************** GET CONTRACT FOLLOWUP BY CONTRACT-FOLLOWUP ID SERVICE  ******************************************** ///
    @Test
    public void shouldReturnContractFollowupWithSpecifiedId(){
        when(contractFollowUpService.findById(any(Integer.class))).thenReturn(Optional.of(contractFollowup));
        Optional<ContractFollowup> result = contractFollowUpService.findById(ContractTestUtiles.contractFollowupId);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.get(),contractFollowup);
    }
}
