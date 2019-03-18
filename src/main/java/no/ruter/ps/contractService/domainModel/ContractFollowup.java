package no.ruter.ps.contractService.domainModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 *
 *
 * @ukbay.gebremeskel@ruter.no
 */

@Data
@AllArgsConstructor
@Entity
@Table(name = "contract_followup")
public class ContractFollowup {
    @Id
    @GeneratedValue(generator = "contractFollowUpId_generator")
    @SequenceGenerator(name = "contractFollowUpId_generator", sequenceName = "contractFollowUp_Id", initialValue = 100)
    private Integer contractFollowUpId;
    @Column(name ="" )@NotNull
    private float totalPlanedDistance;
    private float totalPlanedCalculated;
    private LocalDate localDate;
    private String operatorName;
    private String contractName;
    private String lineList;
    private double feePerMissingPercentPoint;
    private double requiredPercent;
    @Embedded
    private ActualDistanceData actualDistanceData;
    @Column(name = "")
    private float possibleTotalFee;
    @Column(name = "")
    private String reasoningFromOperator;
    @Column(name = "")
    private String reasoningApproved;

    protected ContractFollowup() {
    }

    public ContractFollowup(@NotNull float totalPlanedDistance, float totalPlanedCalculated, LocalDate localDate,
                            String operatorName, String contractName, String lineList, double feePerMissingPercentPoint,
                            double requiredPecent, ActualDistanceData actualDistanceData, float possibleTotalFee,
                            String reasoningFromOperator, String reasoningApproved) {
        this.totalPlanedDistance = totalPlanedDistance;
        this.totalPlanedCalculated = totalPlanedCalculated;
        this.localDate = localDate;
        this.operatorName = operatorName;
        this.contractName = contractName;
        this.lineList = lineList;
        this.feePerMissingPercentPoint = feePerMissingPercentPoint;
        this.requiredPercent = requiredPecent;
        this.actualDistanceData = actualDistanceData;
        this.possibleTotalFee = possibleTotalFee;
        this.reasoningFromOperator = reasoningFromOperator;
        this.reasoningApproved = reasoningApproved;
    }

    private void setContractFollowUpId(Integer contractFollowUpId) {
        this.contractFollowUpId = contractFollowUpId;
    }
}
