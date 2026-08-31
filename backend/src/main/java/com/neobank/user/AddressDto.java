package com.neobank.user;
import jakarta.validation.constraints.NotBlank; import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;
import java.util.UUID;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class AddressDto {
    private UUID id;
    private AddressType addressType;
    @NotBlank(message = "Street line 1 is required") private String streetLine1;
    private String streetLine2;
    @NotBlank(message = "City is required") private String city;
    @NotBlank(message = "State is required") private String stateProvince;
    @NotBlank(message = "Postal code is required") private String postalCode;
    private String country;
    private boolean primary;
}
