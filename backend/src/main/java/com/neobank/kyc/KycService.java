package com.neobank.kyc;
import java.util.List; import java.util.UUID;
public interface KycService {
    List<KycDocument> getUserDocuments(UUID userId);
    KycDocument uploadDocument(UUID userId, String docType, String docNum, String fileName, String fileUrl, long size, String mime);
    void reviewDocument(UUID docId, UUID reviewerId, boolean approved, String reason);
}
