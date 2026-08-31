package com.neobank.transfer;
import lombok.AllArgsConstructor; import lombok.Builder; import lombok.Data; import lombok.NoArgsConstructor;
import java.util.UUID;
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class BeneficiaryDto {
    private UUID id; private String name; private String nickname; private String accountNumber; private String bankName; private String routingNumber; private boolean internal; private boolean favorite;
}
