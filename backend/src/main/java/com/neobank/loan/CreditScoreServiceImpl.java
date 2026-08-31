package com.neobank.loan;
import com.neobank.common.ResourceNotFoundException; import com.neobank.user.User; import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal; import java.math.RoundingMode; import java.time.Instant; import java.util.UUID;
@Service @RequiredArgsConstructor
public class CreditScoreServiceImpl implements CreditScoreService {
    private final CreditAssessmentRepository assessmentRepository; private final UserRepository userRepository;
    @Override @Transactional
    public CreditAssessment evaluateCustomerCredit(UUID userId, BigDecimal annualIncome) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        int score = 740;
        BigDecimal income = annualIncome != null ? annualIncome : new BigDecimal("50000");
        BigDecimal maxLimit = income.multiply(new BigDecimal("0.40")).setScale(2, RoundingMode.HALF_UP);
        CreditAssessment assessment = CreditAssessment.builder()
                .user(user)
                .creditScore(score)
                .debtToIncomeRatio(new BigDecimal("18.5"))
                .maxEligibleLimit(maxLimit)
                .riskTier("PRIME")
                .evaluatedAt(Instant.now())
                .build();
        return assessmentRepository.save(assessment);
    }
}
