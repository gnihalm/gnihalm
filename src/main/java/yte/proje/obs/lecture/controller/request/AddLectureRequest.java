package yte.proje.obs.lecture.controller.request;

import yte.proje.obs.academician.entity.Academician;
import yte.proje.obs.admin.entity.Admin;
import yte.proje.obs.assistant.entity.Assistant;
import yte.proje.obs.lecture.entity.Lecture;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;


public record AddLectureRequest(

        @NotEmpty
        String name,

        @NotEmpty
        String definition,

        @NotEmpty
        String type,

        @NotEmpty
        Long code,

        @NotEmpty
        LocalDateTime dateTime,

        @NotEmpty
        Long room,

        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinColumn(name = "academician_id", referencedColumnName = "ID")
        Long academicianId,

        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinColumn(name = "assistant_id", referencedColumnName = "ID")
        Long assistantId
) {
    public Lecture toLecture(){
        return new Lecture(name, definition, type, code, dateTime, room, academicianId, assistantId);

    }
}
