package com.abba.english.marsrover.controllers;

import com.abba.english.marsrover.Service.MarsRoverService;
import com.abba.english.marsrover.exception.NoTextsToTransmitException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author VSaldanya
 */
@RestController
@RequestMapping("v1/mars-rover")
public class MarsRoverController {


  private MarsRoverService marsRoverService;

  @Autowired
  public MarsRoverController(final MarsRoverService marsRoverService) {
    this.marsRoverService = marsRoverService;
  }

  @PutMapping(value = "/move", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> moveMarsRover(@RequestParam int distance, @RequestParam int angle) {
    return ResponseEntity.ok(new StringResponse(marsRoverService.move(distance, angle)));
  }

  @PutMapping(value = "/charge", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> chargeMarsRoverBatteries() {
    return ResponseEntity.ok(new StringResponse(marsRoverService.chargeBatteries()));
  }

  @PutMapping(value = "/transmit", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> transmitText(@RequestParam String text) {
    return ResponseEntity.ok(new StringResponse(marsRoverService.transmitText(text)));
  }

  @GetMapping(value = "/transmit-random", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> transmitRandomText() throws NoTextsToTransmitException {
    return ResponseEntity.ok(new StringResponse(marsRoverService.transmitRandomText()));
  }

  class StringResponse {

    private String message;

    public StringResponse(String s) {
      this.message = s;
    }

    public String getMessage() {
      return message;
    }
  }

}
