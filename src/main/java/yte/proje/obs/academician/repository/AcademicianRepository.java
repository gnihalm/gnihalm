package yte.proje.obs.academician.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.proje.obs.academician.entity.Academician;
import yte.proje.obs.admin.entity.Admin;

public interface AcademicianRepository extends JpaRepository<Academician, Long> {
}
