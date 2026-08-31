package com.neobank.kyc;
import com.neobank.common.ApiResponse; import com.neobank.security.SecurityUtils;
import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/kyc") @RequiredArgsConstructor
public class KycController {
    private final KycService kycService;
    @GetMapping public ResponseEntity<ApiResponse<List<KycDocument>>> getDocuments() { return ResponseEntity.ok(ApiResponse.success(kycService.getUserDocuments(SecurityUtils.getCurrentUserId()))); }
    @PostMapping("/upload") public ResponseEntity<ApiResponse<KycDocument>> upload(@RequestParam String documentType, @RequestParam(required = false) String documentNumber, @RequestParam String fileName) {
        return ResponseEntity.ok(ApiResponse.success(kycService.uploadDocument(SecurityUtils.getCurrentUserId(), documentType, documentNumber, fileName, "/storage/kyc/" + fileName, 102400L, "application/pdf"), "Document submitted for verification"));
    }
}
