package com.abba.english.marsrover.domain;

import lombok.Data;

@Data
public class MarsRover implements Vehicle {

  public MarsRover() {
    this.location = new Location(0,0);
  }

  Location location;

  @Override
  public String move(Location locationTO) {
    this.location = locationTO;
    return "Movement order received";
  }

  @Override
  public String chargeBatteries() {
    return "Charge Batteries order received";
  }

  @Override
  public String transmitText(String text) {
    return text;
  }
}
