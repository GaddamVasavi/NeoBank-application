package com.neobank.card;
import com.neobank.common.ApiResponse; import com.neobank.security.SecurityUtils;
import lombok.RequiredArgsConstructor; import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal; import java.util.List; import java.util.UUID;
@RestController @RequestMapping("/api/v1/cards") @RequiredArgsConstructor
public class CardController {
    private final CardService cardService;
    @GetMapping public ResponseEntity<ApiResponse<List<CardDto>>> getCards() { return ResponseEntity.ok(ApiResponse.success(cardService.getUserCards(SecurityUtils.getCurrentUserId()))); }
    @PostMapping("/issue") public ResponseEntity<ApiResponse<CardDto>> issueCard(@RequestParam UUID accountId, @RequestParam CardType type, @RequestParam(defaultValue = "false") boolean isVirtual) { return ResponseEntity.ok(ApiResponse.success(cardService.issueCard(SecurityUtils.getCurrentUserId(), accountId, type, isVirtual), "Card issued")); }
    @PatchMapping("/{cardId}/freeze") public ResponseEntity<ApiResponse<CardDto>> toggleFreeze(@PathVariable UUID cardId) { return ResponseEntity.ok(ApiResponse.success(cardService.toggleFreeze(SecurityUtils.getCurrentUserId(), cardId), "Status toggled")); }
    @PutMapping("/{cardId}/controls") public ResponseEntity<ApiResponse<CardDto>> updateControls(@PathVariable UUID cardId, @RequestParam boolean online, @RequestParam boolean international, @RequestParam boolean contactless, @RequestParam(required = false) BigDecimal dailyLimit) { return ResponseEntity.ok(ApiResponse.success(cardService.updateControls(SecurityUtils.getCurrentUserId(), cardId, online, international, contactless, dailyLimit), "Controls updated")); }
    @PostMapping("/{cardId}/pin") public ResponseEntity<ApiResponse<Void>> setPin(@PathVariable UUID cardId, @RequestParam String newPin) { cardService.setPin(SecurityUtils.getCurrentUserId(), cardId, newPin); return ResponseEntity.ok(ApiResponse.success(null, "PIN updated")); }
}
