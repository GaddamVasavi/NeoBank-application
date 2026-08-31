package com.neobank.user;
import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class UserPreferencesDto {
    private String theme;
    private String currency;
    private String language;
    private boolean emailNotifications;
    private boolean smsNotifications;
    private boolean pushNotifications;
    private boolean marketingEmails;
    private boolean twoFactorOnLogin;
    private boolean twoFactorOnTransfer;
}
