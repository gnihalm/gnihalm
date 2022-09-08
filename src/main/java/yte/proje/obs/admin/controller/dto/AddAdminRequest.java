package yte.proje.obs.admin.controller.dto;

import yte.proje.obs.admin.entity.Admin;

public record AddAdminRequest(
        String name,
        String surname,
        String userName,
        String password,
        String email
) {
    public Admin toDomainEntity(){
        return new Admin(name, surname, userName, password, email);

    }
}
