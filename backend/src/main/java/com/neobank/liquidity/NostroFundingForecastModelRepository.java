package com.neobank.liquidity;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.List; import java.util.Optional; import java.util.UUID;
@Repository public interface NostroFundingForecastModelRepository extends JpaRepository<NostroFundingForecastModel, UUID> {
    List<NostroFundingForecastModel> findByUserId(UUID userId);
    Optional<NostroFundingForecastModel> findBySystemIdentifier(String id);
    List<NostroFundingForecastModel> findByValidationState(String state);
}
