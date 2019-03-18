package no.ruter.ps.contractService.controller;

import no.ruter.ps.contractService.domainModel.Line;
import no.ruter.ps.contractService.service.LineService;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(LineController.class)
public class LineControllerTest {
    Logger logger = LoggerFactory.getLogger(LineControllerTest.class);
    @Autowired
    MockMvc mockMvc;
    @MockBean
    private LineService lineService;
    @MockBean
    private ModelMapper modelMapper;
    private Line line;
    private List<Line> lineList;

    @Before
    public  void setup(){
        line = ContractTestUtiles.getLineWithOutId();
        lineList  = new ArrayList<>();

    }

    /// *************************** GET ALL CONTRACT CONTROLLER  ******************************************** ///
    @Test
    public void ShouldReturnListOfLines() throws Exception {
        lineList.add(line);
        // given
        given(lineService.getAllLines()).willReturn(lineList);
        //when
         mockMvc.perform(get("/api/lines").contentType(MediaType.APPLICATION_JSON))
                 .andExpect(status().is(200))
                 .andExpect(jsonPath("$",hasSize(1)))
                 .andExpect(jsonPath("$.[0].lineNumber",is(line.getLineNumber())));
    }

    /// *************************** GET CONTRACT BY ID CONTROLLER  ******************************************** ///
    @Test
    public void ShouldRetureOneLinePublicCode() throws Exception {
        Line line = new Line(100,"150");
        //given
        given(lineService.getLineByLineNumber("150")).willReturn(Optional.of(line));
        //when
        mockMvc.perform(get("/api/lines/line/150")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.lineNumber",is(line.getLineNumber())));
    }

}
