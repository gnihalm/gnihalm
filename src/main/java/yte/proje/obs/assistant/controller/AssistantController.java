package yte.proje.obs.assistant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import yte.proje.obs.admin.entity.Admin;
import yte.proje.obs.assistant.controller.request.AddAssistantRequest;
import yte.proje.obs.assistant.controller.request.UpdateAssistantRequest;
import yte.proje.obs.assistant.controller.response.AssistantResponse;
import yte.proje.obs.assistant.entity.Assistant;
import yte.proje.obs.assistant.service.AssistantService;
import yte.proje.obs.common.dto.response.MessageResponse;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/assistant")
@RequiredArgsConstructor
@Validated
public class AssistantController {

    private final AssistantService assistantService;

    /*public AdminController(final AdminService adminService) {
        this.adminService = adminService;
    }*/

    @GetMapping
    public List<AssistantResponse> getAllAssistant() {
        return assistantService.getAllAssistant()
                .stream()
                .map(assistant -> new AssistantResponse(assistant))
                .toList();
    }

    @PostMapping("/addAssistant")
    public MessageResponse addAssistant(@Valid @RequestBody AddAssistantRequest addAssistantRequest) {
        Assistant assistant = addAssistantRequest.toAssistant();
        return assistantService.addAssistant(assistant);
    }

    @PutMapping("/{id}")
    public MessageResponse updateAssistant(@PathVariable final Long id, @Valid @RequestBody final UpdateAssistantRequest updateAssistantRequest) {
        return assistantService.updateAssistant(id, updateAssistantRequest.toAssistant());
    }

    @DeleteMapping("/{id}")
    public MessageResponse deleteAssistant(@PathVariable Long id) {
        return assistantService.deleteAssistant(id);
    }



}
