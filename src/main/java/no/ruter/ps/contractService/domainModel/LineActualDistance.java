package no.ruter.ps.contractService.domainModel;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 *
 * @ukbay.gebremeskel@ruter.no
 */

@Entity
@Table(name = "line_date_distance")
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LineActualDistance {

    @Id
    @GeneratedValue(generator = "lineDateDistance_generator")
    @SequenceGenerator(name = "lineDateDistance_generator",sequenceName = "id",initialValue = 100)
    private Integer id;
    @NotNull
    private String linePublicCode;
    private float distanceInMeters;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;

    public LineActualDistance(@NotNull String linePublicCode, float distanceInMeters, @NotNull LocalDate date) {
        this.linePublicCode = linePublicCode;
        this.distanceInMeters = distanceInMeters;
        this.date = date;
    }
}
