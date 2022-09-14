package yte.proje.obs.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.proje.obs.admin.entity.Admin;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
