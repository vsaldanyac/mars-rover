package com.abba.english.marsrover.Service;

import com.abba.english.marsrover.domain.MarsRover;
import com.abba.english.marsrover.exception.NoTextsToTransmitException;

/**
 * @author VSaldanya
 */
public interface MarsRoverService {

  String chargeBatteries(Long id);

  String transmitText(Long id, String text);

  MarsRover move(Long id, int distance, int angle);

  String transmitRandomText(Long id) throws NoTextsToTransmitException;
}
