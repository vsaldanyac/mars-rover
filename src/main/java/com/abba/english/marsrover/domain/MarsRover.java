package com.abba.english.marsrover.domain;

public class MarsRover implements Vehicle {
  @Override
  public String move() {
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
