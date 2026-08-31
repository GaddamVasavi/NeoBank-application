package com.neobank.admin;
import java.util.List;
public interface FeatureFlagService {
    boolean isFeatureEnabled(String flagKey);
    List<FeatureFlag> getAllFlags();
    FeatureFlag toggleFlag(String flagKey, boolean enabled);
}
