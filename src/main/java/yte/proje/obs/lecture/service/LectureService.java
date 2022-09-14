package yte.proje.obs.lecture.service;

import org.springframework.stereotype.Service;
import yte.proje.obs.admin.entity.Admin;
import yte.proje.obs.assistant.entity.Assistant;
import yte.proje.obs.common.dto.response.MessageResponse;
import yte.proje.obs.common.dto.response.MessageType;
import yte.proje.obs.lecture.entity.Lecture;
import yte.proje.obs.lecture.repository.LectureRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class LectureService {
    private final LectureRepository lectureRepository;

    public LectureService(final LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    @Transactional
    public MessageResponse addLecture(Lecture lecture) {
        lectureRepository.save(lecture);

        return new MessageResponse("Lecture has been added successfully", MessageType.SUCCESS);
    }

    public List<Lecture> getAllLecture() {
        return lectureRepository.findAll();
    }

    @Transactional
    public MessageResponse updateLecture(Long code, Lecture newLecture) {
         Lecture lecture = lectureRepository.findByCode(code).orElseThrow(() -> new EntityNotFoundException("Lecture with code %s is not found".formatted(code)));
         lecture.UpdateLecture(newLecture);
         lectureRepository.save(lecture);

         return new MessageResponse("Lecture with code %s has been updated successfully!".formatted(code), MessageType.SUCCESS);
    }

    public MessageResponse deleteLecture(Long code) {
        lectureRepository.deleteByCode(code);
        return new MessageResponse("Lecture with code %d has been deleted".formatted(code), MessageType.SUCCESS);
    }




}