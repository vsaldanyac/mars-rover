package com.abba.english.marsrover.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author VSaldanya
 */
@RestController
@RequestMapping("v1/mars-rover")
public class MarsRoverController {

  @PutMapping("/move")
  public ResponseEntity<?> moveMarsRover() {
    return ResponseEntity.ok().build();
  }

  @PutMapping("/charge")
  public ResponseEntity<?> chargeMarsRoverBatteries() {
    return ResponseEntity.ok().build();
  }

  @PutMapping("/transmit")
  public ResponseEntity<?> transmitText(@RequestParam String text) {
    return ResponseEntity.ok(text);
  }

}
