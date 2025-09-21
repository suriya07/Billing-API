package com.billing.core.controller;

import com.billing.core.entity.Invoice;
import com.billing.core.service.InvoiceService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {
  private final InvoiceService service;
  public InvoiceController(InvoiceService service){this.service = service;}

  @GetMapping
  public List<Invoice> list(@RequestParam("tenantId") UUID tenantId){return service.listForTenant(tenantId);}

  @PostMapping
  public Invoice create(@RequestParam("tenantId") UUID tenantId, @RequestBody Invoice inv){return service.create(tenantId, inv);}
}
