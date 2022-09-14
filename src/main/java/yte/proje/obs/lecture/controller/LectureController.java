package yte.proje.obs.lecture.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import yte.proje.obs.admin.entity.Admin;
import yte.proje.obs.admin.service.AdminService;
import yte.proje.obs.common.dto.response.MessageResponse;
import yte.proje.obs.lecture.controller.request.AddLectureRequest;
import yte.proje.obs.lecture.controller.request.UpdateLectureRequest;
import yte.proje.obs.lecture.controller.response.LectureResponse;
import yte.proje.obs.lecture.entity.Lecture;
import yte.proje.obs.lecture.service.LectureService;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/lecture")
@RequiredArgsConstructor
@Validated
public class LectureController {

    private final LectureService lectureService;

    /*public AdminController(final AdminService adminService) {
        this.adminService = adminService;
    }*/

    @GetMapping
    public List<LectureResponse> getAllLecture() {
        return lectureService.getAllLecture()
                .stream()
                .map(lecture -> new LectureResponse(lecture))
                .toList();
    }

    @PostMapping("/addLecture")
    public MessageResponse addLecture(@Valid @RequestBody AddLectureRequest addLectureRequest) {
        Lecture lecture = addLectureRequest.toLecture();
        return lectureService.addLecture(lecture);
    }

    @PutMapping("/{code}")
    public MessageResponse UpdateLecture(@PathVariable final Long code, @Valid @RequestBody final UpdateLectureRequest updateLectureRequest) {
        return lectureService.updateLecture(code, updateLectureRequest.toLecture());
    }

    @DeleteMapping("/{code}")
    public MessageResponse deleteLecture(@PathVariable Long code) {
        return lectureService.deleteLecture(code);
    }


}
