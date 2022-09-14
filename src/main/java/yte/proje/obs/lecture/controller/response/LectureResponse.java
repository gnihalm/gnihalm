package yte.proje.obs.lecture.controller.response;

import lombok.Getter;
import yte.proje.obs.academician.entity.Academician;
import yte.proje.obs.admin.entity.Admin;
import yte.proje.obs.assistant.entity.Assistant;
import yte.proje.obs.lecture.entity.Lecture;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
public class LectureResponse {
    private String name;
    private String definition;
    private String type;
    private Long code;
    private LocalDateTime dateTime;
    private Long room;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "academician_id", referencedColumnName = "ID")
    private Academician academician;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "assistant_id", referencedColumnName = "ID")
    private Assistant assistant;
    public LectureResponse(Lecture lecture) {
        this.name= lecture.getName();
        this.definition = lecture.getDefinition();
        this.type = lecture.getType();
        this.code = lecture.getCode();
        this.dateTime = lecture.getDateTime();
        this.room = lecture.getRoom();
        this.academician = lecture.getAcademician();


    }
}
