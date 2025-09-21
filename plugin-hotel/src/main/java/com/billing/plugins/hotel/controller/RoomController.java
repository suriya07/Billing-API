package com.billing.plugins.hotel.controller;

import com.billing.core.plugin.PluginGuard;
import com.billing.core.config.TenantContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.UUID;

@RestController
@RequestMapping("/api/plugins/hotel/rooms")
public class RoomController {
  private final PluginGuard guard;
  public RoomController(PluginGuard guard){this.guard = guard;}

  @GetMapping
  public ResponseEntity<?> list(){
    UUID tenantId = TenantContext.getCurrentTenant();
    if(tenantId==null) return ResponseEntity.status(401).body("No tenant in context");
    if(!guard.isPluginEnabled(tenantId, "hotel")) return ResponseEntity.status(403).body("Hotel plugin not enabled for tenant");
    return ResponseEntity.ok(java.util.List.of("101","102","201"));
  }
}
