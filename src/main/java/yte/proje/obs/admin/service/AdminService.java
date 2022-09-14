package yte.proje.obs.admin.service;

import org.springframework.stereotype.Service;
import yte.proje.obs.admin.entity.Admin;
import yte.proje.obs.admin.repository.AdminRepository;
import yte.proje.obs.common.dto.response.MessageResponse;
import yte.proje.obs.common.dto.response.MessageType;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(final AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Transactional
    public MessageResponse addAdmin(Admin admin) {
        adminRepository.save(admin);

        return new MessageResponse("Admin has been added successfully", MessageType.SUCCESS);
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Transactional
    public MessageResponse updateAdmin(Long id, Admin newAdmin) {
         Admin admin = adminRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Admin with id %s is not found".formatted(id)));
         admin.updateAdmin(newAdmin);
         adminRepository.save(admin);

         return new MessageResponse("Admin with id %s has been updated successfully!".formatted(id), MessageType.SUCCESS);
    }

    public MessageResponse deleteAdmin(Long id) {
        adminRepository.deleteById(id);
        return new MessageResponse("Admin with ID %d has been deleted", MessageType.SUCCESS);
    }


}