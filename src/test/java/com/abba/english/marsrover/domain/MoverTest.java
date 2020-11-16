package com.abba.english.marsrover.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoverTest {

  @Test
  public void shouldMoveNoMovementLocaltionTest() {
    Mover mover = new Mover();
    Location initLocation = new Location();
    initLocation.setX(0);
    initLocation.setY(0);
    Location finalLocation = mover.moveMarsRover(initLocation, 0, 0);
    assertEquals(finalLocation.getX(), initLocation.getX());
    assertEquals(finalLocation.getY(), initLocation.getY());
  }

  @Test
  public void shouldMoveOneMeterMoveRightTest() {
    Mover mover = new Mover();
    Location initLocation = new Location();
    initLocation.setX(0);
    initLocation.setY(0);
    Location finalLocation = mover.moveMarsRover(initLocation, 1, 0);
    assertEquals(finalLocation.getX(), initLocation.getX() + 1);
    assertEquals(finalLocation.getY(), initLocation.getY());
  }

  @Test
  public void shouldMoveOneMeterMoveLeftTest() {
    Mover mover = new Mover();
    Location initLocation = new Location();
    initLocation.setX(0);
    initLocation.setY(0);
    Location finalLocation = mover.moveMarsRover(initLocation, 1, 180);
    assertEquals(finalLocation.getX(), initLocation.getX() - 1);
    assertEquals(finalLocation.getY(), initLocation.getY());
  }

  @Test
  public void shouldMoveOneMeterMoveForwardTest() {
    Mover mover = new Mover();
    Location initLocation = new Location();
    initLocation.setX(0);
    initLocation.setY(0);
    Location finalLocation = mover.moveMarsRover(initLocation, 1, 90);
    assertEquals(finalLocation.getX(), initLocation.getX());
    assertEquals(finalLocation.getY(), initLocation.getY() + 1);
  }

  @Test
  public void shouldMoveOneMeterMoveBackwardTest() {
    Mover mover = new Mover();
    Location initLocation = new Location();
    initLocation.setX(0);
    initLocation.setY(0);
    Location finalLocation = mover.moveMarsRover(initLocation, 1, 270);
    assertEquals(finalLocation.getX(), initLocation.getX());
    assertEquals(finalLocation.getY(), initLocation.getY() - 1);
  }

  @Test
  public void shouldMoveOneMeterMoveRightFromPositionXOneTest() {
    Mover mover = new Mover();
    Location initLocation = new Location();
    initLocation.setX(1);
    initLocation.setY(0);
    Location finalLocation = mover.moveMarsRover(initLocation, 1, 0);
    assertEquals(finalLocation.getX(), 2);
    assertEquals(finalLocation.getY(), initLocation.getY());
  }

  @Test
  public void shouldMoveOneMeterMoveBackwardFromPositionYMinusOneTest() {
    Mover mover = new Mover();
    Location initLocation = new Location();
    initLocation.setX(0);
    initLocation.setY(-1);
    Location finalLocation = mover.moveMarsRover(initLocation, 1, 270);
    assertEquals(finalLocation.getX(), initLocation.getX());
    assertEquals(finalLocation.getY(), -2);
  }

  @Test
  public void shouldMoveOneMeterMoveForwardFromPositionYOneTest() {
    Mover mover = new Mover();
    Location initLocation = new Location();
    initLocation.setX(0);
    initLocation.setY(1);
    Location finalLocation = mover.moveMarsRover(initLocation, 1, 90);
    assertEquals(finalLocation.getX(), initLocation.getX());
    assertEquals(finalLocation.getY(), 2);
  }

  @Test
  public void shouldMoveOneMeterMoveLeftFromPositionXMinusOneTest() {
    Mover mover = new Mover();
    Location initLocation = new Location();
    initLocation.setX(-1);
    initLocation.setY(0);
    Location finalLocation = mover.moveMarsRover(initLocation, 1, 180);
    assertEquals(finalLocation.getX(), -2);
    assertEquals(finalLocation.getY(), initLocation.getY());
  }

  @Test
  public void shouldMoveTwoMetersDiagonalTest() {
    Mover mover = new Mover();
    Location initLocation = new Location();
    initLocation.setX(0);
    initLocation.setY(0);
    Location finalLocation = mover.moveMarsRover(initLocation, 2, 45);
    assertEquals(finalLocation.getX(), 1);
    assertEquals(finalLocation.getY(), 1);
  }

}