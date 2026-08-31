# FinVerse System Architecture Documentation

FinVerse adopts a modular, domain-driven enterprise architecture separating business domains into discrete bounded contexts.

## Multi-Tenant Isolation Strategy
- Shared database with row-level tenant discriminator (`tenant_id`).
- ThreadLocal `TenantContext` populated by `TenantContextFilter` from `X-Tenant-ID` header and JWT claims.
- Hibernate `@PrePersist` hooks ensuring automatic tenant stamping on all `BaseEntity` subclasses.
