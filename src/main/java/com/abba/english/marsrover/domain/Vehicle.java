package com.abba.english.marsrover.domain;

public interface Vehicle {

  String move(Location locationTO);

  String chargeBatteries();

  String transmitText(String text);
}
