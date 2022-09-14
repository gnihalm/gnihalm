package yte.proje.obs.lecture.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yte.proje.obs.assistant.entity.Assistant;
import yte.proje.obs.common.entity.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Homework extends BaseEntity {

    private String explanation;

    private String pdf;

    private LocalDateTime dueDateTime;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "assistant_id", referencedColumnName = "ID")
    private Assistant assistant;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "lecture_id", referencedColumnName = "ID")
    private Lecture lecture;

}
