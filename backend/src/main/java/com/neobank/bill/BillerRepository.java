package com.neobank.bill;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import java.util.UUID;
@Repository public interface BillerRepository extends JpaRepository<Biller, UUID> {}
