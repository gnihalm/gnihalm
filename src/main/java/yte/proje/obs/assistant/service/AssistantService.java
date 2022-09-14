package yte.proje.obs.assistant.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yte.proje.obs.admin.entity.Admin;
import yte.proje.obs.admin.repository.AdminRepository;
import yte.proje.obs.assistant.entity.Assistant;
import yte.proje.obs.assistant.repository.AssistantRepository;
import yte.proje.obs.common.dto.response.MessageResponse;
import yte.proje.obs.common.dto.response.MessageType;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class AssistantService {
    private final AssistantRepository assistantRepository;

    public AssistantService(final AssistantRepository assistantRepository) {
        this.assistantRepository = assistantRepository;
    }

    @Transactional
    public MessageResponse addAssistant(Assistant assistant) {
        assistantRepository.save(assistant);

        return new MessageResponse("Assistant has been added successfully", MessageType.SUCCESS);
    }

    public List<Assistant> getAllAssistant() {
        return assistantRepository.findAll();
    }

    @Transactional
    public MessageResponse updateAssistant(Long id, Assistant newAssistant) {
        Assistant assistant = assistantRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Assistant with id %s is not found".formatted(id)));
        assistant.updateAssistant(newAssistant);
        assistantRepository.save(assistant);

        return new MessageResponse("Assistant with id %s has been updated successfully!".formatted(id), MessageType.SUCCESS);
    }

    public MessageResponse deleteAssistant(Long id) {
        assistantRepository.deleteById(id);
        return new MessageResponse("Assistant with ID %d has been deleted", MessageType.SUCCESS);
    }
}