package com.billing.core.repository;

import com.billing.core.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface InvoiceRepository extends JpaRepository<Invoice, UUID> {
  List<Invoice> findByTenantId(UUID tenantId);
}
