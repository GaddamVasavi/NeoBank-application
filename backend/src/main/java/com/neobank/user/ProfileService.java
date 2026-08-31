package com.neobank.user;
import java.util.UUID;
public interface ProfileService {
    ProfileDto getProfileByUserId(UUID userId);
    ProfileDto updateProfile(UUID userId, UpdateProfileRequest request);
}
