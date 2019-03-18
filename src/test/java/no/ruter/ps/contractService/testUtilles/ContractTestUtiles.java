package no.ruter.ps.contractService.testUtilles;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.ruter.ps.contractService.dataTransferObjects.ContractDto;
import no.ruter.ps.contractService.dataTransferObjects.ContractFollowUpDto;
import no.ruter.ps.contractService.domainModel.*;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ContractTestUtiles {
    public static Integer contractId = 1235;
    public static Integer lineId = 100;
    public static Integer contractFollowupId = 100;
    public static String contractName = "contractName";
    public static String operatorName = "operatorName";
    public static Integer contractPeriodId = 100;
    public static double productionRequiredInPercent = .5;
    public static String actualDistanceInKM = "actualDistanceInKM";
    public static String actualCalculatedInPercent = "actualCalculatedInPercent";
    public static String missedDistanceInPercent = "missedDistanceInPercent";
    public static long totalFee = 0l;
    public static String reasoningFromOperator = "reasoningFromOperator";
    public static String reasoningApproved = "reasoningApproved";
    public static double feePerMissedInPercentPoint = 500;
    public static ContractPeriod contractPeriod;
    public static String validityPeriod = "01.05.2019 - 30.08.2019";

    public static String lineNumber= "20";
    public static String toParse = "2019-05-02";

    public static Integer contractFollowUpId =4567;

    public static String contractJsonStringWithOutContractId = "{\n" +
            "\t\"contractName\": \"Nittedal og Lørenskog\",\n" +
            "\t\"operatorName\": \"Norgesbuss\",\n" +
            "\t\"lines\": [\n" +
            "\t\t\t {\n" +
            "\t\t\t\t\"lineNumber\": \"120\"\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"lineNumber\": \"310\"\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"lineNumber\": \"315\"\n" +
            "\t\t\t},\n" +
            "\t\t\t\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"lineNumber\": \"385\"\n" +
            "\t\t\t}\n" +
            "\t\t\t\n" +
            "\t\t],\n" +
            "\t\"contractPeriods\": [\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"fromLocalDate\": \"2019-05-02\",\n" +
            "\t\t\t\t\"toLocalDate\": \"2019-07-31\", \n" +
            "\t\t\t\t\"productionRequired\": 0.5,\n" +
            "\t\t\t\t\"feePerMissedInPercentPoint\": 500\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"fromLocalDate\": \"2019-08-01\",\n" +
            "\t\t\t\t\"toLocalDate\": \"2019-08-30\", \n" +
            "\t\t\t\t\"productionRequired\": 0.5,\n" +
            "\t\t\t\t\"feePerMissedInPercentPoint\": 750\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"fromLocalDate\": \"2019-09-01\",\n" +
            "\t\t\t\t\"toLocalDate\": \"2030-09-30\", \n" +
            "\t\t\t\t\"productionRequired\": 0.5,\n" +
            "\t\t\t\t\"feePerMissedInPercentPoint\": 1000\n" +
            "\t\t\t}\n" +
            "\t\t\t\n" +
            "\t\t]\n" +
            "}";

    public static String contractJsonString = " {\n" +
            "        \"contractId\": 100,\n" +
            "        \"contractName\": \"Nittedal og Lørenskog\",\n" +
            "        \"operatorName\": \"Norgesbuss\",\n" +
            "        \"contractPeriods\": [\n" +
            "            {\n" +
            "                \"id\": 100,\n" +
            "                \"fromLocalDate\": \"2019-05-02\",\n" +
            "                \"toLocalDate\": \"2019-07-31\",\n" +
            "                \"productionRequired\": 0.5,\n" +
            "                \"feePerMissedInPercentPoint\": 500\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": 101,\n" +
            "                \"fromLocalDate\": \"2019-08-01\",\n" +
            "                \"toLocalDate\": \"2019-08-30\",\n" +
            "                \"productionRequired\": 0.5,\n" +
            "                \"feePerMissedInPercentPoint\": 750\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": 102,\n" +
            "                \"fromLocalDate\": \"2019-09-01\",\n" +
            "                \"toLocalDate\": \"2030-09-30\",\n" +
            "                \"productionRequired\": 0.5,\n" +
            "                \"feePerMissedInPercentPoint\": 1000\n" +
            "            }\n" +
            "        ],\n" +
            "        \"lines\": [\n" +
            "            {\n" +
            "                \"id\": 100,\n" +
            "                \"lineNumber\": \"120\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": 101,\n" +
            "                \"lineNumber\": \"310\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": 102,\n" +
            "                \"lineNumber\": \"315\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": 103,\n" +
            "                \"lineNumber\": \"385\"\n" +
            "            }\n" +
            "        ]\n" +
            "    }";

    public static ContractPeriod getContractPeriod() throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return contractPeriod = new ContractPeriod(contractPeriodId,LocalDate.parse(
                toParse,formatter),LocalDate.parse(toParse,formatter),productionRequiredInPercent,
                feePerMissedInPercentPoint);
    }
    public static Line getLineWithOutId(){
        return new Line(lineNumber);
    }
    public static Line getLineWithId(){
        return new Line(lineId, lineNumber);
    }

    public static  List<ContractPeriod> getContractPeriodsList() {
        List<ContractPeriod> contractPeriods = new ArrayList<>();
        try {
            contractPeriods.add(getContractPeriod());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return contractPeriods;
    }

    public static ActualDistanceData getActualDistanceData(){
        ActualDistanceData actualDistanceData = new ActualDistanceData();
        actualDistanceData.setActualCalculatedInPercent(actualCalculatedInPercent);
        actualDistanceData.setActualDistanceInKM(actualDistanceInKM);
        actualDistanceData.setMissedDistanceInPercent(missedDistanceInPercent);
        return actualDistanceData;
    }

    public static Contract getContract() throws ParseException{
        return new Contract(contractId,contractName,operatorName,getContractPeriodsList(),getLine());
    }


    public static ContractFollowup getContractFollowupWithId(){
        @NotNull float totalPlanedDistance =12000;
        float totalPlanedCalculated =6000;
        String lineList="31,100,150";
        double requiredPecent =.5;
        return new ContractFollowup(contractFollowUpId,totalPlanedDistance, totalPlanedCalculated, LocalDate.now(),
                operatorName, contractName, lineList, feePerMissedInPercentPoint,
        requiredPecent, new ActualDistanceData(), totalFee,reasoningFromOperator,reasoningApproved);

    }

    public static ContractDto getContractDto() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(contractJsonStringWithOutContractId,ContractDto.class);
    }

    /*public static  ContractFollowup getContractFollowup() throws ParseException{
        return new ContractFollowup(contractFollowUpId,validityPeriod, getContract(),
                getActualDistanceData(),totalFee,reasoningFromOperator,reasoningApproved);
    }
*/
    public static List<Line> getLine(){
        List<Line> lines = new ArrayList<>();
        lines.add(new Line(lineNumber));
        return lines;
    }
}

