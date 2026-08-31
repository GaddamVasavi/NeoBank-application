package com.neobank.user;
import java.util.List; import java.util.UUID;
public interface UserService {
    UserDto getUserById(UUID userId);
    UserDto getCurrentUser();
    void changePassword(UUID userId, ChangePasswordRequest request);
    UserPreferencesDto getUserPreferences(UUID userId);
    UserPreferencesDto updateUserPreferences(UUID userId, UserPreferencesDto preferencesDto);
    List<AddressDto> getUserAddresses(UUID userId);
    AddressDto addAddress(UUID userId, AddressDto addressDto);
    void deleteAddress(UUID userId, UUID addressId);
}
