package com.billing.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PluginMeta {
  @Id
  private String id;
  private String displayName;
  private String version;
  private Boolean active = true;

  public String getId(){return id;}
  public void setId(String id){this.id = id;}
  public String getDisplayName(){return displayName;}
  public void setDisplayName(String displayName){this.displayName = displayName;}
  public String getVersion(){return version;}
  public void setVersion(String version){this.version = version;}
  public Boolean getActive(){return active;}
  public void setActive(Boolean active){this.active = active;}
}
