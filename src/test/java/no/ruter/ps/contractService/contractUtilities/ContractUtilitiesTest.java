package no.ruter.ps.contractService.contractUtilities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class ContractUtilitiesTest {
    Logger logger = LoggerFactory.getLogger(ContractUtilitiesTest.class);
    LocalDate today = LocalDate.now();

    @Before
    public  void setUp(){
    }

    @Test
    public void shouldReturnGivePercentOfTheTotalDistance(){
        double result = ContractUtilities.calculateRequiredPercent(.5,15);

        Assert.assertNotNull(result);
        Assert.assertEquals(7.5,result,0);
    }
    @Test
    public void shouldReturnGivenPercentOfTheTotalDistance(){
        String result = ContractUtilities.calculateRequiredPercent("50",15);
        Assert.assertNotNull(result);
        Assert.assertEquals("7.5",result);
    }

    @Test
    public void shouldSumUpAllDistances(){
        String result = ContractUtilities.calculateTotalDistanceInKm(4,4,4,4);
        Assert.assertNotNull(result);
        Assert.assertEquals("16.0", result);
    }
    @Test
    public void shouldReturnLocalDatefromStringFormate(){
        LocalDate localDate = ContractUtilities.getDateFromString(today.toString());
        Assert.assertNotNull(localDate);
        Assert.assertEquals(localDate,today);
    }
    @Test
    public void compareToLoaclDateShouldComaperWithContractValidityPeriods(){
        LocalDate localDate = LocalDate.now();
        logger.info("Date input : {}", localDate);
        String result = ContractUtilities.compareToLoaclDate(localDate);
        Assert.assertNotNull(result);
        Assert.assertEquals(result,"phaseOne");
    }
}
