package com.billing.core.config;

import java.util.UUID;

public class TenantContext {
  private static final ThreadLocal<UUID> current = new ThreadLocal<>();
  public static void setCurrentTenant(UUID id){current.set(id);}
  public static UUID getCurrentTenant(){return current.get();}
  public static void clear(){current.remove();}
}
