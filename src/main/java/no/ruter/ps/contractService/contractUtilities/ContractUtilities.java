package no.ruter.ps.contractService.contractUtilities;

import lombok.extern.slf4j.Slf4j;
import org.decimal4j.util.DoubleRounder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 *
 *
 * @ukbay.gebremeskel@ruter.no
 */

@Component
@Slf4j
public class ContractUtilities {
    static final String  CONTRACT_PERIOD_END_PHASE1 = "2019-07-31";
    static final String  CONTRACT_PERIOD_END_PHASE2 = "2019-08-30";
    static final String  CONTRACT_PERIOD_END_PHASE3 = "2030-09-30";

    static final public  String CONTRACT_PERIOD_PHASE1 = "phaseOne";
    static final public String CONTRACT_PERIOD_PHASE2 = "phaseTwo";
    static final public String CONTRACT_PERIOD_PHASE3 = "phaseThree";

    public static double calculateRequiredPercent(double percent, double distance){
        return percent* distance;
    }

    public static String calculateRequiredPercent(String percent, double distance){
        return String.valueOf((Double.valueOf(percent)/100)*distance);
    }

    public static String calculateTotalDistanceInKm(double distance1, double distnace2, double distnace3, double distance4){

        return String.valueOf(DoubleRounder.round((distance1+distnace2+distnace3+distance4),3));
    }

    public static int compareTwodate(Date srcDate, Date destDate) {
        int dateCompareresult = 0;
        dateCompareresult = srcDate.compareTo(destDate);
        return dateCompareresult;
    }

    public static LocalDate getDateFromString(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        log.info("input data: {}",date);
        return LocalDate.parse(date,formatter);
    }

    public static String compareToLoaclDate(LocalDate localDate){
        log.info("Input date : {}", localDate);
        if(localDate.isBefore(getDateFromString(CONTRACT_PERIOD_END_PHASE1)) || localDate.isEqual(getDateFromString(CONTRACT_PERIOD_END_PHASE1))){
            return "phaseOne";
        } else if (localDate.isAfter(getDateFromString(CONTRACT_PERIOD_END_PHASE1)) && localDate.isBefore(getDateFromString(CONTRACT_PERIOD_END_PHASE2))){
            return "phaseTwo";
        } else
            return "phaseThree";
    }



}
