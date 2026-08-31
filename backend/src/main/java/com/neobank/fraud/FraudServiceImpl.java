package com.neobank.fraud;
import com.neobank.audit.AuditAction; import com.neobank.audit.AuditService; import com.neobank.audit.AuditSeverity;
import com.neobank.common.ResourceNotFoundException; import com.neobank.user.User; import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal; import java.time.Instant; import java.util.List; import java.util.UUID;
@Service @RequiredArgsConstructor
public class FraudServiceImpl implements FraudService {
    private final FraudCaseRepository caseRepository; private final FraudRuleRepository ruleRepository; private final UserRepository userRepository; private final AuditService auditService;
    @Override
    public int evaluateTransactionRisk(UUID userId, BigDecimal amount) {
        int score = 5;
        if (amount.compareTo(new BigDecimal("5000")) > 0) score += 30;
        if (amount.compareTo(new BigDecimal("10000")) > 0) score += 40;
        if (score >= 50) {
            userRepository.findById(userId).ifPresent(user -> {
                String ref = "CASE-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
                FraudCase fc = FraudCase.builder().user(user).caseReference(ref).riskScore(score).triggerReason("High Value Transfer Threshold Breach: $" + amount).status("OPEN").build();
                caseRepository.save(fc);
            });
        }
        return score;
    }
    @Override @Transactional(readOnly = true) public List<FraudCase> getOpenCases() { return caseRepository.findByStatus("OPEN"); }
    @Override @Transactional
    public void resolveCase(UUID caseId, UUID resolverId, String resolution, String notes) {
        FraudCase fc = caseRepository.findById(caseId).orElseThrow(() -> new ResourceNotFoundException("Case not found"));
        fc.setStatus(resolution);
        fc.setResolutionNotes(notes);
        fc.setAssignedTo(resolverId);
        fc.setResolvedAt(Instant.now());
        caseRepository.save(fc);
    }
    @Override @Transactional(readOnly = true) public List<FraudRule> getRules() { return ruleRepository.findAll(); }
}
