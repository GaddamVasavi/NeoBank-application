package com.neobank.admin;
import com.neobank.account.AccountRepository; import com.neobank.common.ResourceNotFoundException; import com.neobank.fraud.FraudCaseRepository;
import com.neobank.user.User; import com.neobank.user.UserRepository; import com.neobank.user.UserStatus;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap; import java.util.List; import java.util.Map; import java.util.UUID;
@Service @RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final UserRepository userRepository; private final AccountRepository accountRepository; private final FraudCaseRepository fraudCaseRepository;
    @Override @Transactional(readOnly = true)
    public Map<String, Object> getSystemStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("totalUsers", userRepository.count());
        stats.put("totalAccounts", accountRepository.count());
        stats.put("activeFraudCases", fraudCaseRepository.findByStatus("OPEN").size());
        stats.put("systemHealth", "HEALTHY");
        return stats;
    }
    @Override @Transactional(readOnly = true) public List<User> getAllUsers() { return userRepository.findAll(); }
    @Override @Transactional
    public void updateUserStatus(UUID userId, String status) {
        User u = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        u.setStatus(UserStatus.valueOf(status));
        userRepository.save(u);
    }
}
