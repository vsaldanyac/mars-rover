package com.abba.english.marsrover.domain;


/**
 * @author VSaldanya
 */
public interface Vehicle {

  String move(Location locationTO);

  String chargeBatteries();

  String transmitText(String text);
}
