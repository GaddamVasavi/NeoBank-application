package com.neobank.treasuryoperations;
import com.neobank.common.ResourceNotFoundException; import com.neobank.user.User; import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.time.Instant; import java.util.List; import java.util.UUID; import java.util.stream.Collectors;
@Service @RequiredArgsConstructor public class CentralBankAuctionTenderServiceImpl implements CentralBankAuctionTenderService {
    private final CentralBankAuctionTenderRepository repository; private final UserRepository userRepository;
    @Override @Transactional(readOnly = true) public List<CentralBankAuctionTenderDto> getByUser(UUID userId) { return repository.findByUserId(userId).stream().map(this::mapToDto).collect(Collectors.toList()); }
    @Override @Transactional public CentralBankAuctionTenderDto create(CentralBankAuctionTenderDto dto) {
        User u = dto.getUserId() != null ? userRepository.findById(dto.getUserId()).orElse(null) : null;
        CentralBankAuctionTender entity = CentralBankAuctionTender.builder().user(u).clearingIdentifier(dto.getClearingIdentifier() != null ? dto.getClearingIdentifier() : UUID.randomUUID().toString()).settlementStatus(dto.getSettlementStatus() != null ? dto.getSettlementStatus() : "ACTIVE").contractValuation(dto.getContractValuation()).settlementCurrency(dto.getSettlementCurrency() != null ? dto.getSettlementCurrency() : "USD").clearingMemo(dto.getClearingMemo()).reconciled(true).executedTimestamp(Instant.now()).build();
        return mapToDto(repository.save(entity));
    }
    @Override @Transactional(readOnly = true) public CentralBankAuctionTenderDto getByIdentifier(String i) { return repository.findByClearingIdentifier(i).map(this::mapToDto).orElseThrow(() -> new ResourceNotFoundException("Not found")); }
    @Override @Transactional public void updateStatus(UUID id, String s) {
        CentralBankAuctionTender entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        entity.setSettlementStatus(s); repository.save(entity);
    }
    @Override @Transactional(readOnly = true) public List<CentralBankAuctionTenderDto> listAll() { return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList()); }
    private CentralBankAuctionTenderDto mapToDto(CentralBankAuctionTender e) {
        return CentralBankAuctionTenderDto.builder().id(e.getId()).userId(e.getUser() != null ? e.getUser().getId() : null).clearingIdentifier(e.getClearingIdentifier()).settlementStatus(e.getSettlementStatus()).contractValuation(e.getContractValuation()).settlementCurrency(e.getSettlementCurrency()).clearingMemo(e.getClearingMemo()).reconciled(e.isReconciled()).executedTimestamp(e.getExecutedTimestamp()).build();
    }
}
