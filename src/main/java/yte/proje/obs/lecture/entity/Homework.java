package yte.proje.obs.lecture.entity;

import yte.proje.obs.assistant.entity.Assistant;
import yte.proje.obs.common.entity.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Homework extends BaseEntity {

    private String explanation;

    private LocalDateTime dueDateTime;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "assistant_id", referencedColumnName = "ID")
    private Assistant assistant;


}
