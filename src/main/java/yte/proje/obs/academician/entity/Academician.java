package yte.proje.obs.academician.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yte.proje.obs.admin.entity.Admin;
import yte.proje.obs.common.entity.BaseEntity;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Academician extends BaseEntity {

    private String name;
    private String surname;
    private String username;
    private String password;
    private String email;

    public Academician(final String name,
                 final String surname,
                 final String username,
                 final String password,
                 final String email) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public void updateAcademician(final Academician updatedAcademician) {
        this.name = updatedAcademician.name;
        this.surname = updatedAcademician.surname;
        this.username = updatedAcademician.username;
        this.password = updatedAcademician.password;
        this.email = updatedAcademician.email;
    }

}
