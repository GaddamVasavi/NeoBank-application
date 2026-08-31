package com.neobank.common;

import java.time.Instant;

public interface Auditable {
    Instant getCreatedAt();
    Instant getUpdatedAt();
    String getCreatedBy();
    String getLastModifiedBy();
}
