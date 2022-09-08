package yte.proje.obs.admin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yte.proje.obs.admin.controller.dto.AddAdminRequest;
import yte.proje.obs.admin.controller.dto.AdminResponse;
import yte.proje.obs.admin.service.AdminService;
import yte.proje.obs.common.response.MessageResponse;


@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping
    public MessageResponse addAdmin(@RequestBody AddAdminRequest addAdminRequest) {
        return adminService.addAdmin(addAdminRequest.toDomainEntity());
    }


}
