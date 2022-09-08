package yte.proje.obs.admin.controller.dto;

import yte.proje.obs.admin.entity.Admin;

public record UpdateAdminRequest(

        String name,
        String surname,
        String username,
        String password,
        String email
) {
    public Admin toDomainEntity(){
        return new Admin(name,surname,username, password, email);

    }
}
