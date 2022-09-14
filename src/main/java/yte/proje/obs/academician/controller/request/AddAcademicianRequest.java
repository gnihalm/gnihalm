package yte.proje.obs.academician.controller.request;

import yte.proje.obs.academician.entity.Academician;
import yte.proje.obs.admin.entity.Admin;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


public record AddAcademicianRequest(
        @NotEmpty
        String name,
        @NotEmpty
        String surname,
        @NotEmpty
        String username,
        @NotEmpty
        String password,
        @Email
        String email
) {
    public Academician toAcademician(){
        return new Academician(name, surname, username, password, email);

    }
}
