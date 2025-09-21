package com.billing.core.service;

import com.billing.core.entity.Tenant;
import com.billing.core.repository.TenantRepository;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class TenantService {
  private final TenantRepository repo;
  public TenantService(TenantRepository repo){this.repo = repo;}
  public Tenant create(String name){
    Tenant t = new Tenant(); t.setName(name); t.setEnabledPlugins("[\"core\"]");
    return repo.save(t);
  }
  public java.util.List<Tenant> list(){return repo.findAll();}
  public Tenant find(UUID id){ return repo.findById(id).orElse(null);}
  public Tenant save(Tenant t){return repo.save(t);}
}
