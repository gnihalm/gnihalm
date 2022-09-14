package yte.proje.obs.admin.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import yte.proje.obs.admin.controller.request.AddAdminRequest;
import yte.proje.obs.admin.controller.request.UpdateAdminRequest;
import yte.proje.obs.admin.controller.response.AdminResponse;
import yte.proje.obs.admin.entity.Admin;
import yte.proje.obs.admin.service.AdminService;
import yte.proje.obs.common.dto.response.MessageResponse;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@Validated
public class AdminController {

    private final AdminService adminService;

    /*public AdminController(final AdminService adminService) {
        this.adminService = adminService;
    }*/

    @GetMapping
    public List<AdminResponse> getAllAdmins() {
        return adminService.getAllAdmins()
                .stream()
                .map(admin -> new AdminResponse(admin))
                .toList();
    }

    @PostMapping("/addAdmin")
    public MessageResponse addAdmin(@Valid @RequestBody AddAdminRequest addAdminRequest) {
        Admin admin = addAdminRequest.toAdmin();
        return adminService.addAdmin(admin);
    }

    @PutMapping("/{id}")
    public MessageResponse updateAdmin(@PathVariable final Long id, @Valid @RequestBody final UpdateAdminRequest updateAdminRequest) {
        return adminService.updateAdmin(id, updateAdminRequest.toAdmin());
    }

    @DeleteMapping("/{id}")
    public MessageResponse deleteAdmin(@PathVariable Long id) {
        return adminService.deleteAdmin(id);
    }


}
