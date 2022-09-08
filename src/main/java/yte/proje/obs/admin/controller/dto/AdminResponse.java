package yte.proje.obs.admin.controller.dto;

import yte.proje.obs.admin.entity.Admin;

public record AdminResponse(
        Long id,
        String username,
        String password
) {
    public AdminResponse(Admin admin){
        this(
                admin.getId(),
                admin.getUsername(),
                admin.getPassword()
        );

    }

}
