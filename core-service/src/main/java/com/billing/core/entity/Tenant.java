package com.billing.core.entity;

import jakarta.persistence.*;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tenant")
public class Tenant {
  @Id
  @GeneratedValue
  private UUID id;
  private String name;
  private String timezone;
  @Column(columnDefinition = "jsonb")
  private String enabledPlugins;
  private Instant createdAt = Instant.now();

  public List<String> getEnabledPluginsList(){
    if(enabledPlugins==null || StringUtils.isEmpty(enabledPlugins)) return null;
    try{
      com.fasterxml.jackson.databind.ObjectMapper m = new com.fasterxml.jackson.databind.ObjectMapper();
      return m.readValue(enabledPlugins, new com.fasterxml.jackson.core.type.TypeReference<java.util.List<String>>(){});
    }catch(Exception e){return null;}
  }

  // getters and setters
  public UUID getId(){return id;}
  public void setId(UUID id){this.id = id;}
  public String getName(){return name;}
  public void setName(String name){this.name = name;}
  public String getTimezone(){return timezone;}
  public void setTimezone(String timezone){this.timezone = timezone;}
  public String getEnabledPlugins(){return enabledPlugins;}
  public void setEnabledPlugins(String enabledPlugins){this.enabledPlugins = enabledPlugins;}
  public Instant getCreatedAt(){return createdAt;}
  public void setCreatedAt(Instant createdAt){this.createdAt = createdAt;}
}
