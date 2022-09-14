package yte.proje.obs.admin.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import yte.proje.obs.common.entity.BaseEntity;
import yte.proje.obs.lecture.entity.Lecture;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
public class Admin extends BaseEntity {

    private String name;
    private String surname;
    private String username;
    private String password;
    private String email;

    public Admin(final String name,
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

    public void updateAdmin(final Admin updatedAdmin) {
        this.name = updatedAdmin.name;
        this.surname = updatedAdmin.surname;
        this.username = updatedAdmin.username;
        this.password = updatedAdmin.password;
        this.email = updatedAdmin.email;
    }


}
