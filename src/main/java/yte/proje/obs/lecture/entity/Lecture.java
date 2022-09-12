package yte.proje.obs.lecture.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import yte.proje.obs.academician.entity.Academician;
import yte.proje.obs.assistant.entity.Assistant;
import yte.proje.obs.common.entity.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Lecture extends BaseEntity {

    private String name;
    private String definition;
    private String type;
    private Long code;
    private LocalDateTime dateTime;
    private Long room;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "academician_id", referencedColumnName = "ID")
    private Academician academician;

    @OneToMany
    @JoinColumn(name = "assistant_id")
    private Set<Assistant> books = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "exam_id")
    private Set<Exam> exams = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "exam_id")
    private Set<Homework> homeworks = new HashSet<>();

    public Lecture(final String name, final String definition, final String type, final Long code, final LocalDateTime dateTime,
                   final Long room, final Long academicianId,final Long assistantId) {
        this.name = name;
        this.definition = definition;
        this.type = type;
        this.code = code;
        this.dateTime = dateTime;
        this.room = room;
        this.academician = new Academician();
        this.academician.setId(academicianId);
    }


    public void UpdateLecture(final Lecture updatedLecture){
        this.name = updatedLecture.name;
        this.definition = updatedLecture.definition;
        this.type = updatedLecture.type;
        this.code = updatedLecture.code;
        this.dateTime = updatedLecture.dateTime;
        this.room = updatedLecture.room;
        this.academician = updatedLecture.getAcademician();
    }

}
