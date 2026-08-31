package com.neobank.loan;
import com.neobank.common.ResourceNotFoundException; import com.neobank.user.User; import com.neobank.user.UserRepository;
import lombok.RequiredArgsConstructor; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.time.Instant; import java.util.List; import java.util.UUID; import java.util.stream.Collectors;
@Service @RequiredArgsConstructor public class LoanRestructuringPlanServiceImpl implements LoanRestructuringPlanService {
    private final LoanRestructuringPlanRepository repository; private final UserRepository userRepository;
    @Override @Transactional(readOnly = true) public List<LoanRestructuringPlanDto> getByUser(UUID userId) { return repository.findByUserId(userId).stream().map(this::mapToDto).collect(Collectors.toList()); }
    @Override @Transactional public LoanRestructuringPlanDto create(LoanRestructuringPlanDto dto) {
        User u = dto.getUserId() != null ? userRepository.findById(dto.getUserId()).orElse(null) : null;
        LoanRestructuringPlan entity = LoanRestructuringPlan.builder().user(u).recordKey(dto.getRecordKey() != null ? dto.getRecordKey() : UUID.randomUUID().toString()).status(dto.getStatus() != null ? dto.getStatus() : "ACTIVE").metricValue(dto.getMetricValue()).description(dto.getDescription()).payloadData(dto.getPayloadData()).valid(true).timestampRecorded(Instant.now()).build();
        return mapToDto(repository.save(entity));
    }
    @Override @Transactional(readOnly = true) public LoanRestructuringPlanDto getByKey(String k) { return repository.findByRecordKey(k).map(this::mapToDto).orElseThrow(() -> new ResourceNotFoundException("Not found")); }
    @Override @Transactional public void updateStatus(UUID id, String status) {
        LoanRestructuringPlan entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        entity.setStatus(status); repository.save(entity);
    }
    @Override @Transactional(readOnly = true) public List<LoanRestructuringPlanDto> listAll() { return repository.findAll().stream().map(this::mapToDto).collect(Collectors.toList()); }
    private LoanRestructuringPlanDto mapToDto(LoanRestructuringPlan e) {
        return LoanRestructuringPlanDto.builder().id(e.getId()).userId(e.getUser() != null ? e.getUser().getId() : null).recordKey(e.getRecordKey()).status(e.getStatus()).metricValue(e.getMetricValue()).description(e.getDescription()).payloadData(e.getPayloadData()).valid(e.isValid()).timestampRecorded(e.getTimestampRecorded()).build();
    }
}
