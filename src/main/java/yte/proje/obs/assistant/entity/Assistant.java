package yte.proje.obs.assistant.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yte.proje.obs.academician.entity.Academician;
import yte.proje.obs.admin.entity.Admin;
import yte.proje.obs.common.entity.BaseEntity;
import yte.proje.obs.lecture.entity.Lecture;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Assistant extends BaseEntity {

    private String name;
    private String surname;
    private String username;
    private String password;
    private String email;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "academician_id", referencedColumnName = "ID")
    private Academician academician;



    public Assistant(final String name,
                 final String surname,
                 final String username,
                 final String password,
                 final String email, final Long academicianId) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.academician = new Academician();
        this.academician.setId(academicianId);
    }
    public void updateAssistant(final Assistant updatedAssistant) {
        this.name = updatedAssistant.name;
        this.surname = updatedAssistant.surname;
        this.username = updatedAssistant.username;
        this.password = updatedAssistant.password;
        this.email = updatedAssistant.email;
        this.academician = updatedAssistant.academician;
    }
}
