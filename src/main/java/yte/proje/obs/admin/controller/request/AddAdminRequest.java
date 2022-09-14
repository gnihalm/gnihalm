package yte.proje.obs.admin.controller.request;

import yte.proje.obs.admin.entity.Admin;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


public record AddAdminRequest(
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
    public Admin toAdmin(){
        return new Admin(name, surname, username, password, email);

    }
}
