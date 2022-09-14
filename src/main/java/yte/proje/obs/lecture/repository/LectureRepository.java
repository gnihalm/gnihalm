package yte.proje.obs.lecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.proje.obs.lecture.entity.Lecture;

import java.util.List;
import java.util.Optional;

public interface LectureRepository extends JpaRepository<Lecture, Long> {

    Optional<Lecture> findByCode(Long code);
    Optional<Lecture> deleteByCode(Long code);
}
