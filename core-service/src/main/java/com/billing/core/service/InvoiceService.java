package com.billing.core.service;

import com.billing.core.entity.Invoice;
import com.billing.core.repository.InvoiceRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class InvoiceService {
  private final InvoiceRepository repo;
  public InvoiceService(InvoiceRepository repo){this.repo = repo;}
  public List<Invoice> listForTenant(UUID tenantId){return repo.findByTenantId(tenantId);}
  public Invoice create(UUID tenantId, Invoice inv){
    inv.setTenantId(tenantId); return repo.save(inv);
  }
}
