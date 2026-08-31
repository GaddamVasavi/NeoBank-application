package com.neobank.transfer;
import com.neobank.common.ApiResponse; import com.neobank.security.SecurityUtils;
import jakarta.validation.Valid; import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/transfers") @RequiredArgsConstructor
public class TransferController {
    private final TransferService transferService;
    @PostMapping public ResponseEntity<ApiResponse<TransferResponse>> transfer(@Valid @RequestBody TransferRequest request) { return ResponseEntity.ok(ApiResponse.success(transferService.executeTransfer(SecurityUtils.getCurrentUserId(), request), "Transfer successful")); }
    @GetMapping("/beneficiaries") public ResponseEntity<ApiResponse<List<BeneficiaryDto>>> getBeneficiaries() { return ResponseEntity.ok(ApiResponse.success(transferService.getUserBeneficiaries(SecurityUtils.getCurrentUserId()))); }
    @PostMapping("/beneficiaries") public ResponseEntity<ApiResponse<BeneficiaryDto>> addBeneficiary(@Valid @RequestBody BeneficiaryDto dto) { return ResponseEntity.ok(ApiResponse.success(transferService.addBeneficiary(SecurityUtils.getCurrentUserId(), dto), "Beneficiary added")); }
    @DeleteMapping("/beneficiaries/{id}") public ResponseEntity<ApiResponse<Void>> deleteBeneficiary(@PathVariable UUID id) { transferService.deleteBeneficiary(SecurityUtils.getCurrentUserId(), id); return ResponseEntity.ok(ApiResponse.success(null, "Beneficiary removed")); }
}
