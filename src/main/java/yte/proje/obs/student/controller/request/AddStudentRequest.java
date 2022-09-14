package yte.proje.obs.student.controller.request;

import yte.proje.obs.admin.entity.Admin;
import yte.proje.obs.student.entity.Student;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


public record AddStudentRequest(
        @NotEmpty
        String name,
        @NotEmpty
        String surname,
        @NotEmpty
        String stuNumber,
        @NotEmpty
        String password,
        @Email
        String email
) {
    public Student toStudent(){
        return new Student(name, surname, stuNumber, password, email);

    }
}
