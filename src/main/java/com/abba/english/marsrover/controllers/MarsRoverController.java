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

  @PutMapping(value = "{id}/move", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> moveMarsRover(@PathVariable Long id, @RequestParam int distance, @RequestParam int angle) {
    return ResponseEntity.ok(new StringResponse(marsRoverService.move(id, distance, angle)));
  }

  @PutMapping(value = "{id}/charge", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> chargeMarsRoverBatteries(@PathVariable Long id) {
    return ResponseEntity.ok(new StringResponse(marsRoverService.chargeBatteries(id)));
  }

  @PutMapping(value = "{id}/transmit", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> transmitText(@PathVariable Long id, @RequestParam String text) {
    return ResponseEntity.ok(new StringResponse(marsRoverService.transmitText(id, text)));
  }

  @GetMapping(value = "{id}/transmit-random", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> transmitRandomText(@PathVariable Long id) throws NoTextsToTransmitException {
    return ResponseEntity.ok(new StringResponse(marsRoverService.transmitRandomText(id)));
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
