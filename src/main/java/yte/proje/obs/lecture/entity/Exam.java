package yte.proje.obs.lecture.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yte.proje.obs.common.entity.BaseEntity;

import javax.persistence.Entity;
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


}
