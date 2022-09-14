package yte.proje.obs.student.controller;

import org.springframework.web.bind.annotation.*;
import yte.proje.obs.admin.controller.request.AddAdminRequest;
import yte.proje.obs.admin.controller.request.UpdateAdminRequest;
import yte.proje.obs.admin.controller.response.AdminResponse;
import yte.proje.obs.admin.entity.Admin;
import yte.proje.obs.admin.service.AdminService;
import yte.proje.obs.common.dto.response.MessageResponse;
import yte.proje.obs.student.controller.request.AddStudentRequest;
import yte.proje.obs.student.controller.request.UpdateStudentRequest;
import yte.proje.obs.student.controller.response.StudentResponse;
import yte.proje.obs.student.entity.Student;
import yte.proje.obs.student.service.StudentService;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(final StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentResponse> getAllStudents() {
        return studentService.getAllStudents()
                .stream()
                .map(student -> new StudentResponse(student))
                .toList();
    }

    @PostMapping
    public MessageResponse addStudent(@Valid @RequestBody final AddStudentRequest addStudentRequest) {
        Student student = addStudentRequest.toStudent();
        return studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public MessageResponse updateAdmin(@PathVariable final Long id, @Valid @RequestBody final UpdateStudentRequest updateStudentRequest) {
        return studentService.updateStudent(id, updateStudentRequest.toStudent());
    }

    @DeleteMapping("/{id}")
    public MessageResponse deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }



}
