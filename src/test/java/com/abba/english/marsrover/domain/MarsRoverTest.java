package com.abba.english.marsrover.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MarsRoverTest {

  Vehicle marsRover;

  @Before
  public void init() {
    marsRover = new MarsRover();
  }

  @Test
  public void shouldReturnOrderReceivedTest() {
    assertEquals(marsRover.move(), "Movement order received");
  }

  @Test
  public void shouldReturnChargeBatteriesOrderReceivedTest() {
    assertEquals(marsRover.chargeBatteries(), "Charge Batteries order received");
  }

  @Test
  public void shouldTransmitSimpleTextTest() {
    assertEquals(marsRover.transmitText("Sample Text"), "Sample Text");
  }
}