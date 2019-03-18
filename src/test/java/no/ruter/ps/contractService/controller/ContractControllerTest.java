package no.ruter.ps.contractService.controller;

import no.ruter.ps.contractService.dataTransferObjects.ContractDto;
import no.ruter.ps.contractService.domainModel.Contract;
import no.ruter.ps.contractService.service.ContractService;
import no.ruter.ps.contractService.testUtilles.ContractTestUtiles;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ContractController.class)
public class ContractControllerTest {
    Logger logger = LoggerFactory.getLogger(ContractControllerTest.class);

    @Autowired
    private MockMvc mvc;
    @MockBean
    private ContractService contractService;
    @MockBean
    private ModelMapper modelMapper;

    private Contract contract;
    private ContractDto contractDto;

    private List<Contract> contractList;

    @Before
    public void setup() throws ParseException, IOException {
        contract = ContractTestUtiles.getContract();
        contractDto = ContractTestUtiles.getContractDto();
        contractList = new ArrayList<>();
        contractList.add(contract);

    }
    /// *************************** GET ALL CONTRACT CONTROLLER  ******************************************** ///

    @Test
    public void getContracts_shouldReturnAllContracts() throws Exception {
        //given
        given(contractService.getAllContracts()).willReturn(contractList);
        logger.info("out put {}", contractList);
        //when
        mvc.perform(get("/api/contracts")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(1)));
                //.andExpect(jsonPath("$.[0].contractName",is(contract.getContractName())));
                //.andExpect(jsonPath("$.[0].contractName", is(contract.getContractName())));
    }

    /// *************************** GET CONTRACT BY ID CONTROLLER  ******************************************** ///

    @Test
    public void getContractByContractId_shouldReturnOnContract() throws Exception {
        Integer contractId = 150;
        contract.setId(contractId);
        contract.setContractName("Nobina");
        //given
        given(contractService.getContractByContractId(contractId)).willReturn(Optional.of(contract));

        //when
        mvc.perform(get("/api/contracts/150")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(150)))
                .andExpect(jsonPath("$.contractName",is("Nobina")));

    }


    /// *************************** GET CONTRACT BY NAME CONTROLLER  ******************************************** ///

    @Test
    public void getContractByContractName_shouldReturnOneContract() throws Exception {
        String contractName = "NorgeBussen";
        contract.setContractName("NorgeBussen");
        //given
        given(contractService.getContractByContractName(contractName)).willReturn(Optional.of(contract));
        //when
        mvc.perform(get("/api/contracts/contract/NorgeBussen")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1235)))
                .andExpect(jsonPath("$.contractName",is(contractName)));
    }




}

