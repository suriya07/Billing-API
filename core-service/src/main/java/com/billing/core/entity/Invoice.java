package com.billing.core.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "invoice")
public class Invoice {
  @Id
  @GeneratedValue
  private UUID id;
  private UUID tenantId;
  private String invoiceNumber;
  private BigDecimal amount;
  private BigDecimal tax;
  private String status;
  private Instant createdAt = Instant.now();

  // getters/setters
  public UUID getId(){return id;}
  public void setId(UUID id){this.id = id;}
  public UUID getTenantId(){return tenantId;}
  public void setTenantId(UUID tenantId){this.tenantId = tenantId;}
  public String getInvoiceNumber(){return invoiceNumber;}
  public void setInvoiceNumber(String invoiceNumber){this.invoiceNumber = invoiceNumber;}
  public BigDecimal getAmount(){return amount;}
  public void setAmount(BigDecimal amount){this.amount = amount;}
  public BigDecimal getTax(){return tax;}
  public void setTax(BigDecimal tax){this.tax = tax;}
  public String getStatus(){return status;}
  public void setStatus(String status){this.status = status;}
  public Instant getCreatedAt(){return createdAt;}
  public void setCreatedAt(Instant createdAt){this.createdAt = createdAt;}
}
