package com.abba.english.marsrover.domain;

/**
 * @author VSaldanya
 */
public class Mover {
  public Location moveMarsRover(Location initLocation, int distance, int angle) {
    Location newLocation = new Location();
    newLocation.setX((int) (Math.cos(Math.toRadians(angle)) * distance) + initLocation.getX());
    newLocation.setY((int) (Math.sin(Math.toRadians(angle)) * distance) + initLocation.getY());


    return newLocation;

  }
}
