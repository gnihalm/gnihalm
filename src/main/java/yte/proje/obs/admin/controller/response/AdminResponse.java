package yte.proje.obs.admin.controller.response;

import lombok.Getter;
import yte.proje.obs.admin.entity.Admin;

@Getter
public class AdminResponse {
    private final Long id;
    private final String name;
    private final String surname;
    private final String username;
    private final String email;
    private final String password;

    public AdminResponse(Admin admin) {
        this.id = admin.getId();
        this.name = admin.getName();
        this.surname = admin.getSurname();
        this.username = admin.getUsername();
        this.email = admin.getEmail();
        this.password = admin.getPassword();
    }
}
