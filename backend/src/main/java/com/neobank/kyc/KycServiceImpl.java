package com.neobank.kyc;
import com.neobank.audit.AuditAction; import com.neobank.audit.AuditService; import com.neobank.audit.AuditSeverity;
import com.neobank.common.ResourceNotFoundException; import com.neobank.user.User; import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.time.Instant; import java.util.List; import java.util.UUID;
@Service @RequiredArgsConstructor
public class KycServiceImpl implements KycService {
    private final KycDocumentRepository kycRepository; private final UserRepository userRepository; private final AuditService auditService;
    @Override @Transactional(readOnly = true) public List<KycDocument> getUserDocuments(UUID userId) { return kycRepository.findByUserId(userId); }
    @Override @Transactional
    public KycDocument uploadDocument(UUID userId, String docType, String docNum, String fileName, String fileUrl, long size, String mime) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        KycDocument doc = KycDocument.builder().user(user).documentType(docType).documentNumber(docNum).fileName(fileName).fileUrl(fileUrl).fileSizeBytes(size).mimeType(mime).status("PENDING").build();
        KycDocument saved = kycRepository.save(doc);
        auditService.log(userId, user.getUsername(), AuditAction.KYC_SUBMIT, "KycDocument", saved.getId().toString(), "SUCCESS", "KYC Document submitted: " + docType, null, null, AuditSeverity.INFO);
        return saved;
    }
    @Override @Transactional
    public void reviewDocument(UUID docId, UUID reviewerId, boolean approved, String reason) {
        KycDocument doc = kycRepository.findById(docId).orElseThrow(() -> new ResourceNotFoundException("Document not found"));
        doc.setStatus(approved ? "VERIFIED" : "REJECTED");
        doc.setRejectionReason(reason);
        doc.setVerifiedBy(reviewerId);
        doc.setVerifiedAt(Instant.now());
        kycRepository.save(doc);
        if (approved && doc.getUser().getProfile() != null) {
            doc.getUser().getProfile().setKycStatus("VERIFIED");
        }
    }
}
