package com.neobank.user;
import com.neobank.audit.AuditAction; import com.neobank.audit.AuditService; import com.neobank.audit.AuditSeverity;
import com.neobank.common.ResourceNotFoundException; import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final CustomerProfileRepository profileRepository;
    private final UserRepository userRepository;
    private final AuditService auditService;
    @Override @Transactional(readOnly = true)
    public ProfileDto getProfileByUserId(UUID userId) {
        CustomerProfile profile = profileRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("CustomerProfile", "userId", userId));
        return mapToDto(profile);
    }
    @Override @Transactional
    public ProfileDto updateProfile(UUID userId, UpdateProfileRequest request) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        CustomerProfile profile = profileRepository.findByUserId(userId).orElseGet(() -> CustomerProfile.builder().user(user).build());
        profile.setFirstName(request.getFirstName());
        profile.setMiddleName(request.getMiddleName());
        profile.setLastName(request.getLastName());
        profile.setDateOfBirth(request.getDateOfBirth());
        profile.setGender(request.getGender());
        profile.setNationality(request.getNationality() != null ? request.getNationality() : "US");
        profile.setOccupation(request.getOccupation());
        profile.setAnnualIncome(request.getAnnualIncome());
        CustomerProfile saved = profileRepository.save(profile);
        auditService.log(userId, user.getUsername(), AuditAction.PROFILE_UPDATE, "CustomerProfile", saved.getId().toString(), "SUCCESS", "Profile updated", null, null, AuditSeverity.INFO);
        return mapToDto(saved);
    }
    private ProfileDto mapToDto(CustomerProfile p) {
        return ProfileDto.builder()
                .id(p.getId())
                .firstName(p.getFirstName())
                .middleName(p.getMiddleName())
                .lastName(p.getLastName())
                .fullName(p.getFullName())
                .dateOfBirth(p.getDateOfBirth())
                .gender(p.getGender())
                .nationality(p.getNationality())
                .occupation(p.getOccupation())
                .annualIncome(p.getAnnualIncome())
                .kycStatus(p.getKycStatus())
                .riskScore(p.getRiskScore())
                .build();
    }
}
