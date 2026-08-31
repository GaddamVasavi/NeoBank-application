package com.finverse.reporting;

import com.finverse.common.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

/**
 * REST API Controller for DailyFinancialSummaryReport
 */
@Tag(name = "Reporting - DailyFinancialSummaryReport")
@RestController
@RequestMapping("/api/v1/reporting/modules/dailyfinancialsummaryreport")
@RequiredArgsConstructor
public class DailyFinancialSummaryReportController {
    private final DailyFinancialSummaryReportService service;

    @Operation(summary = "List all entities")
    @GetMapping
    public ResponseEntity<ApiResponse<List<DailyFinancialSummaryReportDto>>> listAll() {
        return ResponseEntity.ok(ApiResponse.success(service.listAll()));
    }

    @Operation(summary = "List by tenant ID")
    @GetMapping("/tenant/{tenantId}")
    public ResponseEntity<ApiResponse<List<DailyFinancialSummaryReportDto>>> getByTenant(@PathVariable UUID tenantId) {
        return ResponseEntity.ok(ApiResponse.success(service.getByTenant(tenantId)));
    }

    @Operation(summary = "List by user ID")
    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<List<DailyFinancialSummaryReportDto>>> getByUser(@PathVariable UUID userId) {
        return ResponseEntity.ok(ApiResponse.success(service.getByUser(userId)));
    }

    @Operation(summary = "Create entity")
    @PostMapping
    public ResponseEntity<ApiResponse<DailyFinancialSummaryReportDto>> create(@Valid @RequestBody DailyFinancialSummaryReportDto dto) {
        return ResponseEntity.ok(ApiResponse.success(service.create(dto), "Created successfully"));
    }

    @Operation(summary = "Lookup by reference")
    @GetMapping("/ref/{ref}")
    public ResponseEntity<ApiResponse<DailyFinancialSummaryReportDto>> getByRef(@PathVariable String ref) {
        return ResponseEntity.ok(ApiResponse.success(service.getByReference(ref)));
    }

    @Operation(summary = "Update status")
    @PatchMapping("/{id}/status")
    public ResponseEntity<ApiResponse<Void>> updateStatus(@PathVariable UUID id, @RequestParam String status) {
        service.updateStatus(id, status);
        return ResponseEntity.ok(ApiResponse.success(null, "Updated"));
    }
}
