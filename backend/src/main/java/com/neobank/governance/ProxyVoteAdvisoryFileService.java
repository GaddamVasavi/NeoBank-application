package com.neobank.governance;
import java.util.List; import java.util.UUID;
public interface ProxyVoteAdvisoryFileService {
    List<ProxyVoteAdvisoryFileDto> getByUser(UUID userId);
    ProxyVoteAdvisoryFileDto create(ProxyVoteAdvisoryFileDto dto);
    ProxyVoteAdvisoryFileDto getByRef(String ref);
    void updateStatus(UUID id, String status);
    List<ProxyVoteAdvisoryFileDto> listAll();
}
