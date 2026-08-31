package com.neobank.transfer;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface PeerPaymentContactRepository extends JpaRepository<PeerPaymentContact, UUID> {
    List<PeerPaymentContact> findBySourceAccountId(UUID accountId);
    Optional<PeerPaymentContact> findByTrackingNumber(String trackingNumber);
    List<PeerPaymentContact> findByStatus(String status);
}
