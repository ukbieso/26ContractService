package no.ruter.ps.contractService.domainModel;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 *
 * @ukbay.gebremeskel@ruter.no
 */

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "lines")
public class Line {
    @Id@GeneratedValue(generator = "lineId_generator")
    @SequenceGenerator(name ="lineId_generator", sequenceName = "line_Id",initialValue = 100)
    private Integer id;
    @Column(name = "")
    private String lineNumber;

    public Line(@NotNull String lineNumber) {
        this.lineNumber = lineNumber;
    }


}
