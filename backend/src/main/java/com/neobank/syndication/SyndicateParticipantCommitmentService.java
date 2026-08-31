package com.neobank.syndication;
import java.util.List; import java.util.UUID;
public interface SyndicateParticipantCommitmentService {
    List<SyndicateParticipantCommitmentDto> getByUser(UUID userId);
    SyndicateParticipantCommitmentDto create(SyndicateParticipantCommitmentDto dto);
    SyndicateParticipantCommitmentDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<SyndicateParticipantCommitmentDto> listAll();
}
