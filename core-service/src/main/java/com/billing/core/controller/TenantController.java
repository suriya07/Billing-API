package com.billing.core.controller;

import com.billing.core.entity.Tenant;
import com.billing.core.service.TenantService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tenants")
public class TenantController {
  private final TenantService service;
  public TenantController(TenantService service){this.service = service;}

  @GetMapping
  public List<Tenant> list(){return service.list();}

  @PostMapping
  public Tenant create(@RequestParam String name){return service.create(name);}

  @PostMapping("/enable-plugin")
  public Tenant enablePlugin(@RequestParam java.util.UUID tenantId, @RequestParam String plugin){
    Tenant t = service.find(tenantId);
    try{
      com.fasterxml.jackson.databind.ObjectMapper m = new com.fasterxml.jackson.databind.ObjectMapper();
      java.util.List<String> arr = m.readValue(t.getEnabledPlugins(), new com.fasterxml.jackson.core.type.TypeReference<java.util.List<String>>(){});
      if(!arr.contains(plugin)) arr.add(plugin);
      t.setEnabledPlugins(m.writeValueAsString(arr));
      return service.save(t);
    }catch(Exception e){throw new RuntimeException(e);}
  }
}
