package yte.proje.obs.academician.controller.response;

import lombok.Getter;
import yte.proje.obs.academician.entity.Academician;
import yte.proje.obs.admin.entity.Admin;

@Getter
public class AcademicianResponse {
    private final Long id;
    private final String name;
    private final String surname;
    private final String username;
    private final String email;
    private final String password;

    public AcademicianResponse(Academician academician) {
        this.id = academician.getId();
        this.name = academician.getName();
        this.surname = academician.getSurname();
        this.username = academician.getUsername();
        this.email = academician.getEmail();
        this.password = academician.getPassword();
    }
}
