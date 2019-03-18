package no.ruter.ps.contractService.service;

import no.ruter.ps.contractService.domainModel.Contract;
import no.ruter.ps.contractService.repositories.ContractRepository;
import no.ruter.ps.contractService.testUtilles.ContractTestUtiles;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ContractServiceTest {
    @InjectMocks
    private ContractService contractService;
    @Mock
    private ContractRepository contractRepository;
    private List<Contract> contractList;
    private Contract contract;


    @Before
    public void setUp() throws ParseException {
        contract = ContractTestUtiles.getContract();
        contractList = new ArrayList<>();
        contractList.add(contract);
        when(contractRepository.findAll()).thenReturn(contractList);
        when(contractRepository.findById(ContractTestUtiles.contractId)).thenReturn(Optional.of(contract));
        when(contractRepository.findByContractName(ContractTestUtiles.contractName)).thenReturn(Optional.of(contract));
        when(contractRepository.save(contract)).thenReturn(contract);
    }


    /// *************************** GET ALL CONTRACT SERVICE  ******************************************** ///
    @Test
    public void getAllKontrakt_fetchsAllContract_ReturnsListOfContracts() throws Exception {
        List<Contract> result = contractService.getAllContracts();
        Assert.assertNotNull(result);
        Assert.assertEquals(result, contractList);
        Assert.assertEquals(result.get(0).getId(), ContractTestUtiles.contractId);
    }


    /// *************************** GET A CONTRACT BY CONTRACT ID SERVICE  ******************************************** ///
    @Test
    public void getKontrakt_fetchAContractByContractId_ReturnsAContracts() throws Exception {
        Optional<Contract> result = contractService.getContractByContractId(ContractTestUtiles.contractId);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.get().getId(), ContractTestUtiles.contractId);
    }

    /// *************************** GET A CONTRACT BY CONTRACT NUMBER SERVICE  ******************************************** ///
    @Test
    public void getKontrakt_fetchAContractByContractNumber_ReturnsContracts() throws Exception {
        Optional<Contract> result = contractService.getContractByContractName(ContractTestUtiles.contractName);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.get().getContractName(), ContractTestUtiles.contractName);
        Assert.assertEquals(result.get().getId(), ContractTestUtiles.contractId);
    }

    /// *************************** SAVE A CONTRACT SERVICE  ******************************************** ///
    @Test
    public void saveAKontrakt_ReturnAContracts() throws Exception {
        boolean result = contractService.saveContract(contract);
        Assert.assertNotNull(result);
        Assert.assertFalse(result);

    }

    /// *************************** SAVE A List OF CONTRACT SERVICE (bulk operation)  ******************************************** ///
    @Test
    public void saveAListOfKontrakt_ReturnAListOfContracts() throws Exception {
        String result = contractService.saveListOfContracts(contractList);
        Assert.assertNotNull(result);
        Assert.assertEquals(result, "Contract lists successuflly saved!");
    }

    /// *************************** CHANGE A CONTRACT SERVICE  ******************************************** ///
    @Test
    public void changeKontraktProprties_ReturnSaveChangedKontract() throws Exception {

        contract.setContractName("newContractName");
        boolean result = contractService.changeContractByContractName(contract);
        Assert.assertNotNull(result);
        Assert.assertFalse(result);
    }

}

