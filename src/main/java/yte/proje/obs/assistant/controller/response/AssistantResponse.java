package yte.proje.obs.assistant.controller.response;

import lombok.Getter;
import yte.proje.obs.admin.entity.Admin;
import yte.proje.obs.assistant.entity.Assistant;

@Getter
public class AssistantResponse {
    private final Long id;
    private final String name;
    private final String surname;
    private final String username;
    private final String email;
    private final String password;

    public AssistantResponse(Assistant assistant) {
        this.id = assistant.getId();
        this.name = assistant.getName();
        this.surname = assistant.getSurname();
        this.username = assistant.getUsername();
        this.email = assistant.getEmail();
        this.password = assistant.getPassword();
    }
}
