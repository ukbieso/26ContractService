package no.ruter.ps.contractService.service;

import no.ruter.ps.contractService.domainModel.Line;
import no.ruter.ps.contractService.repositories.LineRepository;
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

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class LinseServiceTest {
    @InjectMocks
    private LineService lineService;
    @Mock
    private LineRepository lineRepository;

    private Line line;
    private List<Line> lineList;

    @Before
    public void setup(){
        line = ContractTestUtiles.getLineWithId();
        lineList = new ArrayList<>();
        lineList.add(line);
    }
    /// *************************** GET ALL LINES SERVICE  ******************************************** ///
    @Test
    public void ShouldReturnAllLines(){
        when(lineRepository.findAll()).thenReturn(lineList);
        List<Line> result = lineService.getAllLines();
        Assert.assertNotNull(result);
        Assert.assertEquals(result.get(0).getId(), ContractTestUtiles.lineId);
    }

    /// *************************** GET LINE BY PUBLIC CODE NUMBER SERVICE  ******************************************** ///
    @Test
    public void shouldReturnLineWithSpecifiedLinePublicCode(){
        when(lineRepository.findByLineNumber(ContractTestUtiles.lineNumber)).thenReturn(Optional.of(line));
        Optional<Line> result = lineService.getLineByLineNumber(ContractTestUtiles.lineNumber);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.get(), line);

    }
    /// *************************** POST SAVE LINE AND CHECK ID AND LINE PUBLIC CODE LINE NUMBER SERVICE  ******************************************** ///
    @Test
    public void shouldSaveLineAndReturnTrue(){
        when(lineRepository.save(ContractTestUtiles.getLineWithOutId())).thenReturn(ContractTestUtiles.getLineWithId());
        boolean isSaved = lineService.saveLine(ContractTestUtiles.getLineWithOutId());
        Assert.assertNotNull(isSaved);
        Assert.assertTrue(isSaved);
    }
    /// *************************** POST TEST TO ELSE BRANCH OF SAVE LINE  SERVICE  ******************************************** ///
    @Test
    public void shouldSaveLineAndReturnFalse(){
        when(lineRepository.save(ContractTestUtiles.getLineWithOutId())).thenReturn(ContractTestUtiles.getLineWithOutId());
        boolean isSaved = lineService.saveLine(ContractTestUtiles.getLineWithOutId());
        Assert.assertNotNull(isSaved);
        Assert.assertFalse(isSaved);
    }

}
