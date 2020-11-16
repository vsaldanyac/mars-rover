package com.abba.english.marsrover.Service;

import com.abba.english.marsrover.exception.NoTextsToTransmitException;

public interface MarsRoverService {

  String chargeBatteries();

  String transmitText(String text);

  String move();

  String transmitRandomText() throws NoTextsToTransmitException;
}
