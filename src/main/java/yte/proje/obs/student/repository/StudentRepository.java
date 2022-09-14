package yte.proje.obs.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.proje.obs.admin.entity.Admin;
import yte.proje.obs.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
