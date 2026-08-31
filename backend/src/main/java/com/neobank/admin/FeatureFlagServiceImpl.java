package com.neobank.admin;
import com.neobank.common.ResourceNotFoundException; import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service @RequiredArgsConstructor
public class FeatureFlagServiceImpl implements FeatureFlagService {
    private final FeatureFlagRepository flagRepository;
    @Override
    public boolean isFeatureEnabled(String flagKey) {
        return flagRepository.findByFlagKey(flagKey).map(FeatureFlag::isEnabled).orElse(false);
    }
    @Override @Transactional(readOnly = true) public List<FeatureFlag> getAllFlags() { return flagRepository.findAll(); }
    @Override @Transactional
    public FeatureFlag toggleFlag(String flagKey, boolean enabled) {
        FeatureFlag flag = flagRepository.findByFlagKey(flagKey).orElseThrow(() -> new ResourceNotFoundException("Feature flag not found: " + flagKey));
        flag.setEnabled(enabled);
        return flagRepository.save(flag);
    }
}
