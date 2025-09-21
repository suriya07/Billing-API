package com.billing.plugins.hotel.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Room {
  @Id
  @GeneratedValue
  private UUID id;
  private String number;
  private String type;

  public UUID getId(){return id;}
  public void setId(UUID id){this.id = id;}
  public String getNumber(){return number;}
  public void setNumber(String number){this.number = number;}
  public String getType(){return type;}
  public void setType(String type){this.type = type;}
}
