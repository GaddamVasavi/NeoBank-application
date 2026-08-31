package com.neobank.kyc;
import com.neobank.common.BaseEntity; import com.neobank.user.User; import jakarta.persistence.*; import lombok.*;
import java.time.Instant; import java.util.UUID;
@Entity @Table(name = "kyc_documents") @Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class KycDocument extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id", nullable = false) private User user;
    @Column(name = "document_type", nullable = false, length = 40) private String documentType;
    @Column(name = "document_number", length = 80) private String documentNumber;
    @Column(name = "file_name", nullable = false) private String fileName;
    @Column(name = "file_url", nullable = false) private String fileUrl;
    @Column(name = "file_size_bytes", nullable = false) private Long fileSizeBytes;
    @Column(name = "mime_type", nullable = false) private String mimeType;
    @Column(name = "status", nullable = false, length = 30) @Builder.Default private String status = "PENDING";
    @Column(name = "rejection_reason") private String rejectionReason;
    @Column(name = "verified_at") private Instant verifiedAt;
    @Column(name = "verified_by") private UUID verifiedBy;
}
