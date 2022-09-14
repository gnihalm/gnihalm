package yte.proje.obs.student.service;

import org.springframework.stereotype.Service;
import yte.proje.obs.admin.entity.Admin;
import yte.proje.obs.admin.repository.AdminRepository;
import yte.proje.obs.common.dto.response.MessageResponse;
import yte.proje.obs.common.dto.response.MessageType;
import yte.proje.obs.student.entity.Student;
import yte.proje.obs.student.repository.StudentRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(final StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public MessageResponse addStudent(Student student) {
        studentRepository.save(student);

        return new MessageResponse("Student has been added successfully", MessageType.SUCCESS);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Transactional
    public MessageResponse updateStudent(Long id, Student newStudent) {
         Student student = studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Student with id %s is not found".formatted(id)));
         student.updateStudent(newStudent);
         studentRepository.save(student);

         return new MessageResponse("Student with id %s has been updated successfully!".formatted(id), MessageType.SUCCESS);
    }

    public MessageResponse deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return new MessageResponse("Student with ID %d has been deleted", MessageType.SUCCESS);
    }


}