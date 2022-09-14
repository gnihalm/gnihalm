package yte.proje.obs.academician.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import yte.proje.obs.academician.controller.request.AddAcademicianRequest;
import yte.proje.obs.academician.controller.request.UpdateAcademicianRequest;
import yte.proje.obs.academician.controller.response.AcademicianResponse;
import yte.proje.obs.academician.entity.Academician;
import yte.proje.obs.academician.service.AcademicianService;
import yte.proje.obs.common.dto.response.MessageResponse;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/academician")
@RequiredArgsConstructor
@Validated
public class AcademicianController {

    private final AcademicianService academicianService;

    /*public AdminController(final AdminService adminService) {
        this.adminService = adminService;
    }*/

    @GetMapping
    public List<AcademicianResponse> getAllAcademician() {
        return academicianService.getAllAcademician()
                .stream()
                .map(academician -> new AcademicianResponse(academician))
                .toList();
    }

    @PostMapping("/addAcademician")
    public MessageResponse addAcademician(@Valid @RequestBody AddAcademicianRequest addAcademicianRequest) {
        Academician academician = addAcademicianRequest.toAcademician();
        return academicianService.addAcademician(academician);
    }

    @PutMapping("/{id}")
    public MessageResponse updateAcademician(@PathVariable final Long id, @Valid @RequestBody final UpdateAcademicianRequest updateAcademicianRequest) {
        return academicianService.updateAcademician(id, updateAcademicianRequest.toAcademician());
    }

    @DeleteMapping("/{id}")
    public MessageResponse deleteAcademician(@PathVariable Long id) {
        return academicianService.deleteAcademician(id);
    }



}
