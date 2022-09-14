package yte.proje.obs.student.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import yte.proje.obs.common.entity.BaseEntity;

import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor
public class Student extends BaseEntity {

    private String name;
    private String surname;
    private String stuNumber;
    private String password;
    private String email;

    public Student(final String name,
                   final String surname,
                   final String stuNumber,
                   final String password,
                   final String email) {
        this.name = name;
        this.surname = surname;
        this.stuNumber = stuNumber;
        this.password = password;
        this.email = email;
    }

    public void updateStudent(final Student updatedStudent) {
        this.name = updatedStudent.name;
        this.surname = updatedStudent.surname;
        this.stuNumber = updatedStudent.stuNumber;
        this.password = updatedStudent.password;
        this.email = updatedStudent.email;
    }


}
