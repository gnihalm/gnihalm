package yte.proje.obs.lecture.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yte.proje.obs.academician.entity.Academician;
import yte.proje.obs.common.entity.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Exam extends BaseEntity {

    private String name;
    private LocalDateTime dateTime;
    private Long room;
    private String generalInfo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "lecture_id", referencedColumnName = "ID")
    private Lecture lecture;

}
