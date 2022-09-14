package yte.proje.obs.student.controller.response;

import lombok.Getter;
import yte.proje.obs.admin.entity.Admin;
import yte.proje.obs.student.entity.Student;

@Getter
public class StudentResponse {
    private final Long id;
    private final String name;
    private final String surname;
    private final String stuNumber;
    private final String email;
    private final String password;

    public StudentResponse(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.surname = student.getSurname();
        this.stuNumber = student.getStuNumber();
        this.email = student.getEmail();
        this.password = student.getPassword();
    }
}
