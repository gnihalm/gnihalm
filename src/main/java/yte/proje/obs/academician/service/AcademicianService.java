package yte.proje.obs.academician.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yte.proje.obs.academician.entity.Academician;
import yte.proje.obs.academician.repository.AcademicianRepository;
import yte.proje.obs.admin.entity.Admin;
import yte.proje.obs.admin.repository.AdminRepository;
import yte.proje.obs.common.dto.response.MessageResponse;
import yte.proje.obs.common.dto.response.MessageType;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class AcademicianService {

    private final AcademicianRepository academicianRepository;

    public AcademicianService(final AcademicianRepository academicianRepository) {
        this.academicianRepository = academicianRepository;
    }

    @Transactional
    public MessageResponse addAcademician(Academician academician) {
        academicianRepository.save(academician);

        return new MessageResponse("Academician has been added successfully", MessageType.SUCCESS);
    }

    public List<Academician> getAllAcademician() {
        return academicianRepository.findAll();
    }

    @Transactional
    public MessageResponse updateAcademician(Long id, Academician newAcademician) {
        Academician academician = academicianRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Academicianwith id %s is not found".formatted(id)));
        academician.updateAcademician(newAcademician);
        academicianRepository.save(academician);

        return new MessageResponse("Academician with id %s has been updated successfully!".formatted(id), MessageType.SUCCESS);
    }

    public MessageResponse deleteAcademician(Long id) {
        academicianRepository.deleteById(id);
        return new MessageResponse("Academician with ID %d has been deleted", MessageType.SUCCESS);
    }
}