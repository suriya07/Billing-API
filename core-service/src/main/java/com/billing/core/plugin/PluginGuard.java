package com.billing.core.plugin;

import com.billing.core.entity.Tenant;
import com.billing.core.repository.TenantRepository;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
public class PluginGuard {
  private final TenantRepository tenantRepository;
  public PluginGuard(TenantRepository tenantRepository){this.tenantRepository = tenantRepository;}

  public boolean isPluginEnabled(UUID tenantId, String pluginId){
    Tenant t = tenantRepository.findById(tenantId).orElse(null);
    if(t==null) return false;
    try{
      com.fasterxml.jackson.databind.ObjectMapper m = new com.fasterxml.jackson.databind.ObjectMapper();
      java.util.List<String> arr = m.readValue(t.getEnabledPlugins(), new com.fasterxml.jackson.core.type.TypeReference<java.util.List<String>>(){});
      return arr.contains(pluginId);
    }catch(Exception e){return false;}
  }
}
