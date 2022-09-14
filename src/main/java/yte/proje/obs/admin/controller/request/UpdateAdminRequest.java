package yte.proje.obs.admin.controller.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import yte.proje.obs.admin.entity.Admin;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


public record UpdateAdminRequest(
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
        return new Admin(name,surname,username, password, email);

    }
}
