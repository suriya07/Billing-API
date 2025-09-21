package com.billing.core.plugin;

import com.billing.core.repository.TenantRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class PluginLoader {
  private final TenantRepository tenantRepository;
  public PluginLoader(TenantRepository tenantRepository){this.tenantRepository = tenantRepository;}
  @PostConstruct
  public void report(){
    tenantRepository.findAll().forEach(t -> System.out.printf("Tenant %s plugins=%s\n", t.getName(), t.getEnabledPlugins()));
  }
}
