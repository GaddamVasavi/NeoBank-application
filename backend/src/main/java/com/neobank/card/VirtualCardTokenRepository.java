package com.neobank.card;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.UUID;
@Repository public interface VirtualCardTokenRepository extends JpaRepository<VirtualCardToken, UUID> {
    List<VirtualCardToken> findByCardIdAndActiveTrue(UUID cardId);
}
