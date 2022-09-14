package yte.proje.obs.assistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.proje.obs.admin.entity.Admin;
import yte.proje.obs.assistant.entity.Assistant;

public interface AssistantRepository extends JpaRepository<Assistant, Long> {
}
