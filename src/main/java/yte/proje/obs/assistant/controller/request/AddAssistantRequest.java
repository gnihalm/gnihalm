package yte.proje.obs.assistant.controller.request;

import yte.proje.obs.admin.entity.Admin;
import yte.proje.obs.assistant.entity.Assistant;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


public record AddAssistantRequest(
        @NotEmpty
        String name,
        @NotEmpty
        String surname,
        @NotEmpty
        String username,
        @NotEmpty
        String password,
        @Email
        String email,
        Long academicianId
) {
    public Assistant toAssistant(){
        return new Assistant(name, surname, username, password, email, academicianId);

    }
}
