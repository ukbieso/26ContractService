package no.ruter.ps.contractService.domainModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;


/**
 *
 *
 * @ukbay.gebremeskel@ruter.no
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "line_followup")
public class LineFollowup {
    @Id@GeneratedValue(generator = "lineFollowupId_generator")
    @SequenceGenerator(name = "lineFollowupId_generator",sequenceName = "lineFollowup_id", initialValue = 100)
    private Integer id;
    @Embedded
    private ActualDistanceData actualDistanceData;
    @OneToOne
    private Line line;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "")
    private LocalDate followupDate;
    @Column(name = "")
    private double totalPlannedDistanceInKm;
}

