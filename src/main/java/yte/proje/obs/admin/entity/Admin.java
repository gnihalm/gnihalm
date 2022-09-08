package yte.proje.obs.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yte.proje.obs.common.entity.BaseEntity;
import yte.proje.obs.common.entity.enums.HesapTuru;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Admin extends BaseEntity {

    private String name;

    private String surname;
    private String username;
    private String password;
    private String email;

}
