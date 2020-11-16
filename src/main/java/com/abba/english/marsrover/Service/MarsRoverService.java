package com.abba.english.marsrover.Service;

import com.abba.english.marsrover.exception.NoTextsToTransmitException;

public interface MarsRoverService {

  String chargeBatteries(Long id);

  String transmitText(Long id, String text);

  String move(Long id, int distance, int angle);

  String transmitRandomText(Long id) throws NoTextsToTransmitException;
}
