package yte.proje.obs.admin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yte.proje.obs.admin.entity.Admin;
import yte.proje.obs.admin.repository.AdminRepository;
import yte.proje.obs.common.response.MessageResponse;
import yte.proje.obs.common.response.ResponseType;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;
    public MessageResponse addAdmin(Admin admin) {
        adminRepository.save(admin);
        return new MessageResponse(ResponseType.SUCCESS, "Admin kullanıcısı başarıyla eklenmiştir.");
    }
}